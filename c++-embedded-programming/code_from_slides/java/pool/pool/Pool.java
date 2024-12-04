package pool;

import java.util.Arrays;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Tracks the availability of an instance of E.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
class Item<E> {
    /**
      * Initialize an Item.
      *
      * @param prototype       Value to be referenced (must be unique for each item)
      * @since                 1.0
      */
    public Item(E prototype) {
        value = prototype;
        free = true;
    }
    E value;       // What is stored in each pool slot
    boolean free;  // false if allocated, true if available
}

/**
 * Pre-allocates values to a copy of <code>prototype</code> supplied and manages 
 * their use in an array by the application.
 * The generic type E <b>must</b> include a public copy constructor 
 * (though E itself need not be public), or else an <code>AssertionError</code> 
 * will be thrown.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Pool<E> {
    /**
      * Pre-allocate <code>size</code> instances of E, each containing a copy of <code>prototype</code>.
      *
      * @throws AssertionError if the array values cannot be pre-allocated
      * @param size            the number of values in this container
      * @param prototype       a copy of <code>prototype</code> will be referenced by each value
      * @since                 1.0
      */
    public Pool(int size, E prototype) { 
        items = new Object[size];
        
        // "Reflection" - find the copy constructor for the generic type
        //   because shockingly, we can't simply invoke ``new E()`` nor can
        //   we invoke its overridden clone() method because in the Object
        //   superclass clone() is protected (why???). *sigh*
        // So we accept an E instance, and copy it to new memory addresses.
        Class<?> prototypeClass = prototype.getClass();
        Constructor<?> copyConstructor = null;
        try {
            copyConstructor = prototypeClass.getConstructor(prototypeClass);
        } catch(NoSuchMethodException e) {
            throw new AssertionError("Pool type must provide a public copy constructor");
        }
            
        // Now load a copy of the prototype into each array element, 
        //   in the process pre-allocating all memory to be used by the Pool
        for(int i=0; i<size; ++i) {
            try {
                //@SuppressWarning("unchecked") 
                E prototypeCopy = (E) copyConstructor.newInstance(prototype);
                items[i] = new Item(prototypeCopy);
            } catch(InstantiationException 
                  | IllegalAccessException
                  | InvocationTargetException e) {
                throw new AssertionError("Unable to instance objects for pool");
            }
        }
    }
    /**
      * Returns a value from the pool, or <code>null</code> if none are available.
      *
      * @since                 1.0
      */
    public E get() {
        for(Object o : items) {
            Item<E> item = (Item<E>) o;
            if (item.free) {
                item.free = false;
                return item.value;
            }
        }
        return null;            // No items available
    }
    /**
      * Release <code>value</code> back to the pool, which must have been previously 
      * provided by {@link #get()}. 
      * <ul>
      *   <li>Ignored if <code>value</code> is already free.</li>
      *   <li>If <code>value</code> isn't in the pool, it is referenced by 
      *       <code>lostValue</code>, which serves as an error flag.</li>
      * </ul>
      *
      * @param value       the instance of E to return to the pool
      * @since                 1.0
      */
    public void free(E value) {  
        for(Object o : items) {
            Item<E> item = (Item<E>) o;
            if (item.value == value) {
                item.free = true;
                return;
            }
        }
        lostValue = value;        // Could not file item
    }
    /**
      * Returns a table of each pool item's toString() and status, 
      *   always in array order. 
      *
      * For status,
      *
      * <ul>
      *   <li>"is free" means the item is not allocated.</li>
      *   <li>"is null" means the item is allocated but its value is null.</li>
      *   <li>"stores <i>hashcode</i>" means the item is allocated 
      *       and its value's <code>hashCode</code> is shown.</li>
      * </ul>
      *
      * @since                 1.0
      */
    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<items.length; ++i) {
            Item<E> item = (Item<E>) items[i];
            result += "---- " + i + " " + item + " ";
            if(item.free) result += " is free\n";
            else {
                if(item.value == null) result += " stores null\n";
                else result += String.format(" stores 0x%x\n", item.value.hashCode());
            }
        }
        return result;
    }
    private Object[] items; // Item<E>[] items;
    
    /**
      * Error flag which if not <code>null</code> indicates an attempt to free 
      * a value not in the pool. After finding an error, assign null to 
      * <code>lostValue</code> to detect the next error.
      *
      * <ul>
      *   <li>null means no error.</li>
      *   <li>any value is a reference to the value not found in the pool.</li>
      * </ul>
      *
      * @since                 1.0
      */
    public E lostValue = null;
}
