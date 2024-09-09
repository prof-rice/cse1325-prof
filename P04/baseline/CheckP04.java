// UNCOMMENT line 3 if you choose to place this in your test package.
// OTHERWISE run this from the cse1325/P04 directory.
// package test;

// This class will provide an interactive test for a COMPLETED P04 implementation.
//
// This public domain code was written by Professor George F. Rice in 2024,
// and all copyright is disclaimed.
// 
// Disclaimer of Liability
//
// The code in this file is provided "as is", with NO WARRANTY and includes
// no guarantee of any kind, express or implied, with respect to the completeness, 
// accuracy, availability, or suitability to any particular purpose.
// Your decision to use this software is ENTIRELY at your own risk.

import moes.Moes;

import product.Media;

import customer.Student;

import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

import java.util.Scanner;

public class CheckP04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Create a MOES instance
        Moes moes = new Moes();
        
        // Add two students, one with unlimited and one with ala carte
        moes.addStudent(new Student("A. Media Hound", 1234567890, "amh7890@uta.edu", true));
        moes.addStudent(new Student("Casual Carl", 1234567891, "cc7891@uta.edu", false));
        System.out.print("Buy how many points for Casual Carl? ");
        moes.buyPoints(1, in.nextInt()); in.nextLine(); // Buy points for Casual Carl
        
        // Add a couple of media selections
        moes.addMedia(new Media("The Terror of Tiny Town", 
                                "https://en.wikipedia.org/wiki/File:The_Terror_of_Tiny_Town.webm",
                                3));
        moes.addMedia(new Media("The Mechanical Monsters (Superman)", 
                                "https://www.youtube.com/watch?v=6LEfzup0aNs",
                                5));

        // Ask for and play media
        System.out.print("\nMOES Users\n\n" + moes.getStudentList() + "\nWhich user? ");
        int studentIndex = in.nextInt(); in.nextLine();
        int points = moes.getPoints(studentIndex);
        if(points == Integer.MAX_VALUE)
            System.out.println("Unlimited Account");
        else
            System.out.println("Available points: " + moes.getPoints(studentIndex));
        System.out.print("\nMOES Media\n\n" + moes.getMediaList() + "\nWhich media? ");
        int mediaIndex = in.nextInt(); in.nextLine();
        
        System.out.println(moes.playMedia(studentIndex, mediaIndex));
        
        System.out.println("Points remaining: " + moes.getPoints(studentIndex));
    }

}
