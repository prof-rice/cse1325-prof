package mdi;

import moes.Moes;
import product.Media;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import customer.Student;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// See MenuItem.java and Menu.java for the keys to this approach!

public class Main {
    public Main() {
        this.moes = new Moes();
        this.output = "";
        this.menu = new Menu(); 
        
        menu.addMenuItem(new MenuItem("Exit\n",                () -> endApp()));
        menu.addMenuItem(new MenuItem("Play media",            () -> playMedia()));
        menu.addMenuItem(new MenuItem("List media",            () -> listMedia()));
        menu.addMenuItem(new MenuItem("List available points", () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy points",          () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add media\n",             () -> addMedia()));
        menu.addMenuItem(new MenuItem("List all students",     () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add a student",         () -> addStudent()));
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N   M E N U
    
    // Method mdi() runs the menu system
    private boolean running = true;
    public void mdi() {
        while(running) {
            try {
                Integer i = selectFromMenu();
                if(i != null) menu.run(i);
            } catch (Exception e) {
                error("Invalid command", e);
            } 
        }
    }
    // Show the main menu and return the char selected
    private final String title = "\n".repeat(255) +
    """
                           \\\\\\///
                          / _  _ \\
                        (| (.)(.) |)
     .----------------.OOOo--()--oOOO.---------------.
     |                                               |
     |    Mavs Online Entertainment System (MOES)    |
     |    Version 0.3.0           ©2024 Prof Rice    |
     |                                               |
     '-----------------------------------------------'


    """;
    
    private final String sep = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

    private Integer selectFromMenu() {
        if(!output.isEmpty()) output = sep + output + sep;
        System.out.println(title + menu + output);
        output = "";
        return Menu.getInt("Selection? ");
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          U S E R   O U T P U T
    // Instead of System.out.println, which would put output ABOVE the menu,
    //   collect output in a String field and print it BETWEEN the menu
    //   and the prompt. This looks MUCH nicer!
    private void print(Object s) {
        output += "\n" + s + '\n';
    }
    private void error(Object s, Exception e) {
        output += "\n#### " + s + '\n';
        if(e != null) output += "  => " + e + '\n';
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          U T I L I T I E S
    private Integer inputStudentIndex() {
        System.out.println(moes.getStudentList());
        return Menu.getInt("Student number? ", "");    
    }
    private Integer inputMediaIndex() {
        System.out.println(moes.getMediaList());
        return Menu.getInt("Media number? ", "");
    }
    // /////////////////////////////////////////////////////////////////////////
    //                          R E S P O N D E R s
    // These methods implement each command offered in the menu
    private void endApp() {
        running = false;
    }

    private void playMedia() {
        try {
            print(moes.playMedia(inputStudentIndex(), inputMediaIndex()));
        } catch (Exception e) {
            error("Unable to play media", e);
        }
    }
    private void listMedia() {
        try {
            print("Media Available via MOES\n========================");
            print(moes.getMediaList());
        } catch(Exception e) {
            error("Unable to display media list", e);
        }
    }
    private void listAvailablePoints() {
        try {
            int studentIndex = inputStudentIndex();
            print(moes.getStudent(studentIndex) + " has " + moes.getPoints(studentIndex) + " points");
        } catch(Exception e) {
            error("Unable to look up point totals", e);
        }
    }
    private void buyPoints() {
        try {
            int studentIndex = inputStudentIndex();
            int currentPoints = moes.getPoints(studentIndex);
            System.out.println(moes.getStudent(studentIndex) + " currently has " 
                             + moes.getPoints(studentIndex) + " points");
            int buyPoints = Menu.getInt("Number of additional points to buy? ");
            if(buyPoints <= 0) {
                error("Can only buy positive points", null); 
                return;
            }
            print(moes.buyPoints(studentIndex, buyPoints));
            print("\n" + moes.getStudent(studentIndex) + " bought " + buyPoints + " points");
        } catch (Exception e) {
            error("Unable to buy points", e);
        }
    }
    private void addStudent() {
        try {
            String name = Menu.getString("Student name? ", ""); if (name == null) return;
            Integer id = Menu.getInt("Student ID? ", ""); if (id == null) return;
            String email = Menu.getString("Student email? ", ""); if (email == null) return;
            Character account = Menu.getChar("(a)lacarte or (u)nlimited? ", ""); if (account == null) return;
            Student student = new Student(name, id, email, (Character.toUpperCase(account) == 'U'));
            moes.addStudent(student);
            print("Added student " + student);
        } catch(Exception e) {
            error("Unable to add student", e);
        }
    }
    private void listStudents() {
        try {
            print("Students Registered with MOES\n=============================");
            print(moes.getStudentList());
        } catch(Exception e) {
            error("Unable to list students", e);
        }
    }
    private void addMedia() {
        try {
            String title = Menu.getString("Title? ", ""); if (title == null) return;
            String url = Menu.getString("URL? ", ""); if (url == null) return;
            Integer points = Menu.getInt("Points? ", ""); if (points == null) return;
            Media media = new Media(title, url, points);
            moes.addMedia(media);
            print("Added media " + media);
        } catch(Exception e) {
            error("Unable to add media", e);
        }
    }
    
    private Moes moes;
    private String output;
    private Scanner in = new Scanner(System.in);
    private Menu menu;
    
    public static void main(String[] args) {
        Main main = new Main();
        main.mdi();
    }
}

