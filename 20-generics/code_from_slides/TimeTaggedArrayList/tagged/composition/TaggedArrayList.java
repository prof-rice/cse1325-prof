package tagged.composition;

import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.text.SimpleDateFormat;

class TaggedObject<E> {
    TaggedObject(E value) {
        this.date = new Date();
        this.value = value;
    }
    @Override
    public String toString() {
        return "'" + value + "' (at " + formatDate.format(date) + ")";
    }

    Date date;
    E value;
    private static SimpleDateFormat formatDate = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
    
public class TaggedArrayList<E> {
    public TaggedArrayList() {
        list = new ArrayList<>();
    }
    public void add(E element) {
        list.add(new TaggedObject<E>(element));
    }
    public E get(int index) {
        return list.get(index).value;
    }
    public Date when(int index) {
        return list.get(index).date;
    }
    public int size() {
        return list.size();
    }
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("[");
        String sep = "";
        for(var e : list) {
            result.append(sep + e);
            sep = "\n ";
        }
        result.append(']');
        return result.toString();
    }
    // This new overload returns the string representation
    //   of both the element AND the time tag
    public String toString(int index) {
        return list.get(index).toString();
    }
    private ArrayList<TaggedObject<E>> list;
}
