import java.util.HashMap;
import java.util.Iterator;

import java.util.Objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

abstract class Book {
    public Book(String title, long isbn) {
        this.title = title;
        this.isbn = isbn;
    }
    public Book(BufferedReader br) throws IOException {
        this(br.readLine(), Long.parseLong(br.readLine()));
    }
    @Override
    public String toString() {
        return title + "(ISBN " + isbn + ", ";
    }
    protected String title;
    protected long isbn;
}


class Paperback extends Book {
    public Paperback(String title, long isbn, double weight) {
        super(title, isbn);
        this.weight = weight;
    }
    public Paperback(BufferedReader br) throws IOException{
        super(br);
        this.weight = Double.parseDouble(br.readLine());
    }
    @Override
    public String toString() {
        return super.toString() + "paperback, " + weight + " kg)";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;   
        if(o == null) return false;  
        if(o.getClass() != this.getClass()) return false; 
        Paperback pb = (Paperback) o;  
        return pb.title.equals(title)  
            && pb.isbn == isbn
            && pb.weight == weight;
    }
    @Override
    public int hashCode() { 
        return Objects.hash(title, isbn, weight); 
    }
    private double weight;
}

class eBook extends Book {
    public eBook(String title, long isbn, int kilobytes) {
        super(title, isbn);
        this.kilobytes = kilobytes;
    }
    public eBook(BufferedReader br) throws IOException {
        super(br);
        this.kilobytes = Integer.parseInt(br.readLine());
    }
    @Override
    public String toString() {
        return super.toString() + "digital, " + kilobytes + " kb)";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        eBook eb = (eBook) o;
        return eb.title.equals(title)
            && eb.isbn == isbn
            && eb.kilobytes == kilobytes;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, kilobytes);
    }
    private int kilobytes;
}

public class Bookstore {
    public Bookstore() { }
    public Bookstore(BufferedReader br) throws IOException {
        int pairs = Integer.parseInt(br.readLine());
        Book book;
        while(pairs-- > 0) {
            if(br.readLine().equals("ebook")) book = new eBook(br);
            else book = new Paperback(br);
            priceList.put(book, Double.parseDouble(br.readLine()));
        }
    }
    private HashMap<Book, Double> priceList = new HashMap<>(); 
    public void addBook(Book book, double price) {
        priceList.put(book, price);
    }
    @Override
    public String toString() {  
        String catalog = "";
        Iterator<Book> it = priceList.keySet().iterator();
        while(it.hasNext()) {
            Book b = it.next();
            catalog += String.format("%-50s $%6.2f\n", b, priceList.get(b)); 
        }
        return catalog;
    }
    
    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        store.addBook(new Paperback("The Martian", 9780553418026L, 0.3), 8.99);
        store.addBook(new eBook("The Martian", 9780553418026L,  3693), 7.99);
        System.out.println(store);
    }
}


