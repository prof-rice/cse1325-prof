package timetagged.composition;

import java.util.Scanner;

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
    String toString() {
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

    public static void main(String[] args) {
    	TaggedArrayList<String> list = new TaggedArrayList<>(); // TaggedArrayList is generic

    	System.out.println("Enter several lines of text. Press Ctrl-d when finished.");
        Scanner scanner = new Scanner(System.in);
    	while(scanner.hasNextLine) list.add(scanner.nextLine());
        System.out.println("\nThe data entered (with time tags) are:\n");
        System.out.println(list);
    }
}
