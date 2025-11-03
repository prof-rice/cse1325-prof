package demo;

import menu.Menu;
import menu.MenuItem;

public class Demo {
    public Demo() {
        menu = new Menu("Test TaggedArrayList\n====================\n\n",
                        "\n\nSelection? ",
                        new MenuItem("Exit",                       () -> exit()),
                        new MenuItem("New composition array list", () -> newComp()),
                        new MenuItem("New inheritance array list", () -> newInherit())
         );
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.mdi();
    }
    public void mdi() {
        menu.run();
    }
    private void exit() {
        menu.result = null; // exit the menu
    }
    private void newComp() {
        tagged.composition.TaggedArrayList<String> list = 
            new tagged.composition.TaggedArrayList<>();
        String line;
        while(!(line = Menu.getString("Enter text: ")).equals(""))
            list.add(line);
        menu.result.append("\nThe data entered (with time tags) are:\n\n" + list);
    }
    private void newInherit() {
        tagged.inheritance.TaggedArrayList<String> list = 
            new tagged.inheritance.TaggedArrayList<>();
        String line;
        while(!(line = Menu.getString("Enter text: ")).equals(""))
            list.add(line);
        menu.result.append("\nThe data entered (with time tags) are:\n\n" + list);
    }
    private Menu menu;
}
