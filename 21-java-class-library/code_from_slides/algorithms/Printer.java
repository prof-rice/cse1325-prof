import java.util.List;

public class Printer {
    public static void print(Object[] array) {
        String sep = "";
        for(var v : array) {
            System.out.print(sep + v); 
            sep = " ";
        }
        System.out.println();
        if(showIndices) {
            String index = "";
            for(int i=0; i<array.length; ++i)
                System.out.print(((i<10) ? " " : "") + i + " ".repeat(array[i].toString().length()-1));
            System.out.println();
        }
    }
    public static void print(List list) {
        print(list.toArray()); // toArray returns Object[], since we provided no array
    }
    public static boolean showIndices = false;
}
