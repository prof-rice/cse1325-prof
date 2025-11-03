import java.util.Scanner;

public class TestTaggedArrayList {
    public static void main(String[] args) {
        (new TestTaggedArrayList()).mdi();
    }
    
    public TestTaggedArrayList() {
        menu.addMenuItem(new MenuItem("Exit", () -> exit()));
        menu.addMenuItem(new MenuItem("Add a String", () -> addString()));
        menu.addMenuItem(new MenuItem("Add an Integer", () -> addInteger()));
        menu.addMenuItem(new MenuItem("Add a Coordinate", () -> addCoordinate()));
    }
    
    public void mdi() {
        while(running) {
            String input = "";
            try {
                System.out.print("\n".repeat(255) + "MAIN MENU\n=========\n\n"
                              + menu + data() + "\nSelection? ");
                input = in.nextLine();
                menu.run(Integer.parseInt(input));
            } catch(Exception e) {
                System.err.println("#### Invalid input: " + input);
            }
        }
    }
    private String data() {
        StringBuilder sb = new StringBuilder();
        if(strings.size() > 0) {
            sb.append("\nStrings\n=======\n");
            for(int i=0; i<strings.size(); ++i) 
                sb.append("" + strings.when(i) + " '" + strings.get(i) + "'\n");
            sb.append('\n');
        }
        if(ints.size() > 0) {
            sb.append("\nIntegers\n========\n");
            for(int i=0; i<ints.size(); ++i) 
                sb.append("" + ints.when(i) + " '" + ints.get(i) + "'\n");
            sb.append('\n');
        }
        if(coords.size() > 0) {
            sb.append("\nCoordinates\n===========\n");
            for(int i=0; i<coords.size(); ++i) 
                sb.append("" + coords.when(i) + " '" + coords.get(i) + "'\n");
            sb.append('\n');
        }
        return sb.toString();
    }
    private void exit() {
        running = false;
    }
    private void addString() {
        System.out.print("String? ");
        strings.add(in.nextLine());
    }
    private void addInteger() {
        System.out.print("Integer? ");
        ints.add(in.nextInt()); discard = in.nextLine();
    }
    private void addCoordinate() {
        System.out.print("Coordinate (x y z)? ");
        coords.add(new Coordinate(
            in.nextDouble(), 
            in.nextDouble(), 
            in.nextDouble())); discard = in.nextLine();
    }
    
    private TaggedArrayList<String> strings = new TaggedArrayList<>();
    private TaggedArrayList<Integer> ints = new TaggedArrayList<>();
    private TaggedArrayList<Coordinate> coords = new TaggedArrayList<>();
    
    private Menu menu = new Menu();
    private Scanner in = new Scanner(System.in);
    private boolean running = true;
    private String discard;
}
