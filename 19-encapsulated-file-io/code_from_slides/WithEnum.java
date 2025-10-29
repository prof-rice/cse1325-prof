import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.Objects;

import menu.Menu;

enum Color {NONE, OTHER, RED, WHITE, BLUE, GOLD, GREEN, BLACK, ORANGE, BROWN, GRAY, PURPLE}

class Flag {
    Color color1;
    Color color2;
    Color color3;

    public Flag(Color color1, Color color2, Color color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }
    public Flag(Scanner in) throws IOException {
        color1 = Color.valueOf(in.nextLine());
        color2 = Color.valueOf(in.nextLine());
        color3 = Color.valueOf(in.nextLine());
    }
    public void save(PrintStream out) throws IOException {
        out.println(color1.name());
        out.println(color2.name());
        out.println(color3.name());
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Flag that = (Flag) o;
        return this.color1 == that.color1
            && this.color2 == that.color2
            && this.color3 == that.color3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color1, color2, color3);
    }

    @Override
    public String toString() {
        return "" + color1 + ", " + color2 + ", and " + color3;
    }
}

public class WithEnum {
    public static void main(String[] args) {
        String sep = "\n================\n";
        File cwd = new File(System.getProperty("user.dir"));
        Color[] colors = Color.values(); // Array of enumeration values
        
        System.out.println("\n\nCreating a new flag!" + sep + "\n");
        Flag flag = new Flag(colors[Menu.selectItemFromArray("Select first color:", colors)],
                             colors[Menu.selectItemFromArray("Select second color:", colors)],
                             colors[Menu.selectItemFromArray("Select third color:", colors)]);
        System.out.println("Flag created is " + flag);
        
        System.out.println("\n\n" + sep);
        File file = Menu.selectFile("Select or create file to save it:", cwd, null);
        try(PrintStream out = new PrintStream(file)) {
            flag.save(out);
            System.out.println("Saved flag to " + file.getName());
        } catch(Exception e) {
            System.err.println("FAIL: Unable to write flag: " + e);
            System.exit(-1);
        }
        
        System.out.println("\n\n" + sep);
        file = Menu.selectFile("Select file from which to load another flag:", cwd, null);
        try(Scanner in = new Scanner(file)) {
            flag = new Flag(in);
        } catch(Exception e) {
            System.err.println("FAIL: Unable to write flag: " + e);
            System.exit(-1);
        }
        System.out.println("Flag loaded is " + flag);
    }
}
