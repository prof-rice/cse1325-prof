import java.util.Arrays;

public class SortedArray<E> {
    @SuppressWarnings("unchecked") // CANNOT fail cast as all data is of type E
    public SortedArray(int size) {
        array = (E[]) new Object[size]; // Uncheck warning if not suppressed
        nextElement = 0;
    }
    public int maxSize() {
        return array.length;
    }
    public int size() {
        return nextElement;
    }
    public void add(E e) {
        array[nextElement] = e;
        Arrays.sort(array, 0, ++nextElement);
    }
    public E get(int index) {
        return array[index]; 
    }
    
    private E[] array;
    private int nextElement;
}
