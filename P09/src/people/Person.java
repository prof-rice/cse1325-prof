package people;

import rating.Rateable;
import rating.Rating;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Person implements Rateable {
    public Person(String name, String email) {
        if(name  == null || name.isEmpty() ||
           email == null || email.isEmpty())
           throw new IllegalArgumentException("Undefined name or email");
        this.name = name;
        this.email = email;
        this.ratings = new ArrayList<>();
    }
    public Person(Scanner in) {
        this.name = in.nextLine();
        this.email = in.nextLine();
        this.ratings = new ArrayList<>();
    }
    public void save(PrintStream out) {
        out.println(name);
        out.println(email);
    }
    public String getName() {
        return name;
    }
    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
    @Override
    public double getAverageRating() {
        double sum = 0;
        for(Rating r : ratings) sum += r.getStars();
        return sum / ratings.size();
    }
    @Override
    public Rating[] getRatings() {
        return ratings.toArray(new Rating[ratings.size()]);
    }
    @Override
    public String toString() { 
        return name + " (" + email + ")";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Person p = (Person) o;
        return p.name.equals(name) &&
               p.email.equals(email);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, email);
    }
    protected String name;
    protected String email;
    private List<Rating> ratings;
}
