import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;

class TaggedObject<E> {
    public TaggedObject(Date date, E value) {
        this.date = date;
        this.value = value;
    }
    public String toString() {
        return "'" + value + "' (at " + formatDate.format(date) + ")";
    }

    public Date date;
    public E value;
    private static SimpleDateFormat formatDate = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
    
public class TaggedArrayList<E> {
    public TaggedArrayList() {
        list = new ArrayList<>();
    }
    public void add(E element) {
        list.add(new TaggedObject<E>(new Date(), element));
    }
    public E get(int index) {
        return list.get(index).value;
    }
    public Date when(int index) {
        return list.get(index).date;
    }
    // This new overload returns the string representation
    //   of both the element AND the time tag
    public String toString(int index) {
        return list.get(index).toString();
    }
    public int size() {
        return list.size();
    }
    private ArrayList<TaggedObject<E>> list;

    public static void main(String[] args) {
    	TaggedArrayList<String> list = new TaggedArrayList<>(); // TaggedArrayList is generic
        list.add("The answer is ");
        list.add("forty-two");
        for (int i=0; i<list.size(); ++i) {  // Haven't covered iterators yet, so 3-term for
            System.out.println(list.toString(i));
        }
    }
}
