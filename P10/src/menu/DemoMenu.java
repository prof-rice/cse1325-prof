package menu;

import java.util.ArrayList;

public class DemoMenu {
    public static void main(String[] args) {
        DemoMenu demo = new DemoMenu();
        demo.mdi();
    }        

    public DemoMenu() {
        menu.addMenuItem(new MenuItem("Exit\n",                   () -> endApp()));
        menu.addMenuItem(new MenuItem("Enter String",             () -> enterString()));
        menu.addMenuItem(new MenuItem("Recall String",            () -> recallString()));
        menu.addMenuItem(new MenuItem("Select predefined String", () -> selectString()));
        menu.addMenuItem(new MenuItem("Reverse String",           this::reverse));
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N   M E N U
    
    private static final String title = "\n".repeat(255) + " ".repeat(30) + "- = # D E M O # = -\n\n";    
    private static final String sep = "\n" + "~".repeat(80) + "\n";
    private boolean running = true;

    // Method mdi() runs the menu system
    public void mdi() {
        while(running) {
            try {
                System.out.println(title + menu + sep + output + activeString + sep);
                output = "";
                Integer i = Menu.getInt("\nSelection ('x' to cancel): ", "x");
                if(i != null) menu.run(i);
            } catch (Exception e) {
                output = "\n\nInvalid command\n" + e + "\n\n";
            } 
        }
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          R E S P O N D E R s
    // These methods implement each command offered in the menu
    private void endApp() {
        running = false;
    }

    private void enterString() {
        String s = Menu.getString("Enter a new string ('" + activeString + "'): ", "x", activeString);
        if(s == null) return;
        activeString = s;
        if(enteredStrings.indexOf(s) < 0 && !s.isEmpty()) enteredStrings.add(s);
    }

    private void recallString() {
        Integer index = Menu.selectItemFromList("Recall string index: ", enteredStrings, "x", activeString);
        if(index != null) activeString = enteredStrings.get(index);
        else output = "No strings available to recall yet.\n\n";
    }

    private void selectString() {
        Integer index = Menu.selectItemFromArray("Load predefined string index: ", predefinedStrings, "x", activeString);
        if(index != null) activeString = predefinedStrings[index];
    }

    private void reverse() {
        activeString = (new StringBuilder(activeString)).reverse().toString();
    }

    private String activeString = "";
    private String output = "";
    private Menu menu = new Menu();
    private ArrayList<String> enteredStrings = new ArrayList<>();
    private String[] predefinedStrings = new String[]{"No guts, no glory.", "Prove them wrong.",
        "Try. Fail. Fail better.", "No pressure, no diamonds.", "Broken crayons still color.", 
        "He who is brave is free.", "Leap and the net will appear.", "Boom, baby!"};
}
