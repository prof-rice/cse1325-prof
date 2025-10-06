import java.util.Comparator;

class SortByLength implements Comparator<String> {
    public int compare(String lhs, String rhs) {
        int key = lhs.length() - rhs.length();
        if (key == 0) key = lhs.compareTo(rhs);
        return key;
    }
}

