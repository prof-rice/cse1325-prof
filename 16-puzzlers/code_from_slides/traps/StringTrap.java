public class StringTrap {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        String d = ("he" + "llo");
        String e = ("he" + new String("llo"));

        System.out.println("\"hello\" == \"hello\": " + (a == b));
        System.out.println("\"hello\" == new String(\"hello\"): " + (a == c));
        System.out.println("\"hello\" == (\"he\" + \"llo\"): " + (a == d));
        System.out.println("\"hello\" == (\"he\" + new String(\"llo\")): " + (a == e));
    }
}

