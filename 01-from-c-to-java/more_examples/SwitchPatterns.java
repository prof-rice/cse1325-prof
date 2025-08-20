enum Color{RED, GREEN, BLUE};

public class SwitchPatterns {
    public static String toString(Object o) {
        return switch(o) {
            case null -> "null";
            case String s
            when s.length() == 0 -> "Empty String";
            case String s -> "String: " + s;
            case Color c -> "Color: " + c;
            default -> "Other: " + o.toString();
        };
    }
    public static void main(String[] args) {
        Object o = Color.RED;
        String s = toString(o);
        System.out.println(s);
        System.out.println(toString(""));
    }
}

