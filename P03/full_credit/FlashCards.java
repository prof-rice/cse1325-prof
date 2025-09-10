import java.util.Scanner;
import java.util.Random;

public class FlashCards {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static String GREEN = "\033[38;2;0;255;0m";
    private static String RED   = "\033[38;2;255;0;0m";
    private static String RESET = "\033[0m";

    public static final int numCards = 27;
    private static Card[] loadDeck() {
        Card[] cards = new Card[numCards];
        int i = 0;
        cards[i++] = new Card("Abstraction", "Specifying a general interface while hiding implementation details");
        cards[i++] = new Card("Algorithm", "A procedure for solving a specific problem, expressed as an ordered set of actions");
        cards[i++] = new Card("Assertion", "An expression that, if false, indicates a program error");
        cards[i++] = new Card("Class", "A template encapsulating data and code that manipulates it");
        cards[i++] = new Card("Constructor", "A special class member that creates and initializes an object from the class");
        cards[i++] = new Card("Copyright", "Exclusive right to print, publish, perform, execute, or record a creative work or its derivatives, and to authorize others to do the same");
        cards[i++] = new Card("Data Validation", "Ensuring that a program operates on clean, correct and useful data");
        cards[i++] = new Card("Declaration", "A statement that introduces a name with an associated type into a scope");
        cards[i++] = new Card("Definition", "A declaration that also fully specifies the entity declared");
        cards[i++] = new Card("Encapsulation", "Bundling data and code into a restricted container");
        cards[i++] = new Card("Enumerated type", "A data type that includes a fixed set of constant values called enumerators");
        cards[i++] = new Card("Exception", "An object created to represent an error or other unusual occurrence and then propagated via special mechanisms until caught by special handling code");
        cards[i++] = new Card("Field", "A class member variable");
        cards[i++] = new Card("Getter", "A method that returns the value of a private variable");
        cards[i++] = new Card("Intellectual Property", "Exclusive right to authors and inventors to their writing and discoveries");
        cards[i++] = new Card("Invariant", "Code for which specified assertions are guaranteed to be true");
        cards[i++] = new Card("Method", "A function that manipulates data in a class");
        cards[i++] = new Card("Object", "An instance of a class containing a set of encapsulated data and associated methods");
        cards[i++] = new Card("Object-Oriented Programming (OOP)", "A style of programming focused on the use of classes and class hierarchies");
        cards[i++] = new Card("Operator", "A short string representing a mathematical, logical, or machine control action");
        cards[i++] = new Card("Patent", "Exclusive right to make, use, or sell an invention, and authorize others to do the same");
        cards[i++] = new Card("Setter", "A method that changes the value of a private variable");
        cards[i++] = new Card("Shadowing", "A variable declared in a narrower scope than that of a variable of the same name declared in a broader scope");
        cards[i++] = new Card("Trademark", "Symbol or name established by use as representing a company or product");
        cards[i++] = new Card("Unified Modeling Language (UML)", "The standard visual modeling language used to describe, specify, design, and document the structure and behavior of object-oriented systems");
        cards[i++] = new Card("Validation Rules", "Algorithmically enforceable constraints on the correctness, meaningfulness, and security of input data");
        cards[i++] = new Card("Variable", "A block of memory associated with a symbolic name that contains a primitive data value or the address of an object instance");
        return cards;
    }
    
    public static void main(String[] args) {
        Card[] deck = loadDeck();
        System.out.println("\n".repeat(80) + "FLASH CARDS\n===========\n\nVocabulary terms:\n");
        for(Card card : deck) 
            System.out.println("* " + card.getTerm());

        while(true) {
            Card card = deck[random.nextInt(deck.length)];
            System.out.print("\n" + card + "\nWhich term matches this definition ('q' to quit)? ");
            if(!scanner.hasNextLine()) break;
            String term = scanner.nextLine();
            if(term.equals("q")) break;
            if(card.attempt(term)) System.out.println(GREEN + "Correct!" + RESET);
            else System.out.println(RED + "No, the term is " + card.getTerm() + RESET);
        }
    }
}
