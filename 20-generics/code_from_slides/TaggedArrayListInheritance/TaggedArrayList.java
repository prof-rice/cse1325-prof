import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TaggedArrayList<E> extends ArrayList<E> {
    // Shadow all of ArrayList's known constructors
    public TaggedArrayList() {
        super();  // Note that super() must ALWAYS be first
        dates = new ArrayList<>();
    }
    public TaggedArrayList(int initialCapacity) {
        super(initialCapacity);
        dates = new ArrayList<>(initialCapacity);
    }
    public TaggedArrayList(Collection<? extends E> c) {
        super(c);
        dates = new ArrayList<>();
        for(E e : this) dates.add(new Date());
    }
    
    // Override the "important" methods to handle time tags
    //   (Iterators are ignored, as we haven't covered them yet)
    // We have a very real risk of data leakage getting the super
    //   and dates lists out of sync - checkSync detects this
    @Override
    public void add​(int index, E element) {
        checkSync();
        dates.add(index, new Date());
        super.add(index, element);
    }
    @Override
    public boolean add(E element) {
        checkSync();
        dates.add(new Date());
        return super.add(element);
    }
    @Override
    public boolean	addAll​(Collection<? extends E> c) {
        checkSync();
        for(E e : c) dates.add(new Date());
        return super.addAll(c);
    }
    @Override
    public void clear() {
        checkSync();
        dates.clear();
        super.clear();
    }
    @Override
    public E remove(int index) {
        checkSync();
        dates.remove(index);
        return super.remove(index);
    }
    @Override
    public E set​(int index, E element) {
        checkSync();
        dates.set(index, new Date());
        return super.set(index, element);
    }
    @Override
    public void 	trimToSize() {
        checkSync();
        dates.trimToSize();
        super.trimToSize();
    }
    
    // Additional methods to support time tagging
    
    // When is the getter for the date, similar to get for data
    public Date when(int index) {
        return dates.get(index);
    }
    // This new overload of toString returns the string representation
    //     of both the element AND the time tag
    public String toString(int index) {
        return "'" + this.get(index) + "' (at " + formatDate.format(dates.get(index)) + ")";
    }
    
    // Private utility method to verify that the data structures are coherent
    private void checkSync() {
        assert super.size() == dates.size();
    }
    
    // Attributes
    private ArrayList<Date> dates;
    private static SimpleDateFormat formatDate = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

}

