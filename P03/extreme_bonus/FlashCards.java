import java.util.Scanner;

public class FlashCards {
    private static Scanner scanner = new Scanner(System.in);
    private static String GREEN = "\033[38;2;0;255;0m"; // These are "ANSI codes" and work in most terminals
    private static String RED   = "\033[38;2;255;0;0m"; // Notably, the Windows command.exe does NOT support them!
    private static String RESET = "\033[0m";

    private static Deck loadDeck() {
        Deck deck = new Deck();
        deck.addCard(new Card("Abstraction", "Specifying a general interface while hiding implementation details"));
        deck.addCard(new Card("Algorithm", "A procedure for solving a specific problem, expressed as an ordered set of actions"));
        deck.addCard(new Card("Assertion", "An expression that, if false, indicates a program error"));
        deck.addCard(new Card("Class", "A template encapsulating data and code that manipulates it"));
        deck.addCard(new Card("Constructor", "A special class member that creates and initializes an object from the class"));
        deck.addCard(new Card("Copyright", "Exclusive right to print, publish, perform, execute, or record a creative work or its derivatives, and to authorize others to do the same"));
        deck.addCard(new Card("Data Validation", "Ensuring that a program operates on clean, correct and useful data"));
        deck.addCard(new Card("Declaration", "A statement that introduces a name with an associated type into a scope"));
        deck.addCard(new Card("Definition", "A declaration that also fully specifies the entity declared"));
        deck.addCard(new Card("Encapsulation", "Bundling data and code into a restricted container"));
        deck.addCard(new Card("Enumerated type", "A data type that includes a fixed set of constant values called enumerators"));
        deck.addCard(new Card("Exception", "An object created to represent an error or other unusual occurrence and then propagated via special mechanisms until caught by special handling code"));
        deck.addCard(new Card("Field", "A class member variable"));
        deck.addCard(new Card("Getter", "A method that returns the value of a private variable"));
        deck.addCard(new Card("Intellectual Property", "Exclusive right to authors and inventors to their writing and discoveries"));
        deck.addCard(new Card("Invariant", "Code for which specified assertions are guaranteed to be true"));
        deck.addCard(new Card("Method", "A function that manipulates data in a class"));
        deck.addCard(new Card("Object", "An instance of a class containing a set of encapsulated data and associated methods"));
        deck.addCard(new Card("Object-Oriented Programming (OOP)", "A style of programming focused on the use of classes and class hierarchies"));
        deck.addCard(new Card("Operator", "A short string representing a mathematical, logical, or machine control action"));
        deck.addCard(new Card("Patent", "Exclusive right to make, use, or sell an invention, and authorize others to do the same"));
        deck.addCard(new Card("Setter", "A method that changes the value of a private variable"));
        deck.addCard(new Card("Shadowing", "A variable declared in a narrower scope than that of a variable of the same name declared in a broader scope"));
        deck.addCard(new Card("Trademark", "Symbol or name established by use as representing a company or product"));
        deck.addCard(new Card("Unified Modeling Language (UML)", "The standard visual modeling language used to describe, specify, design, and document the structure and behavior of object-oriented systems"));
        deck.addCard(new Card("Validation Rules", "Algorithmically enforceable constraints on the correctness, meaningfulness, and security of input data"));
        deck.addCard(new Card("Variable", "A block of memory associated with a symbolic name that contains a primitive data value or the address of an object instance"));
        return deck;
    }
    
    public static void main(String[] args) {
        Deck deck = loadDeck();
        System.out.println("\n".repeat(80) + "FLASH CARDS\n===========\n\n" + deck);

        while(true) {
            Card card = deck.deal();
            System.out.print("\n" + card + "\nWhich term matches this definition ('q' to quit)? ");
            if(!scanner.hasNextLine()) break;
            String term = scanner.nextLine();
            if(term.equals("q")) break;
            if(card.attempt(term)) System.out.println(GREEN + "Correct!" + RESET);
            else System.out.println(RED + "No, the term is " + card.getTerm() + RESET);
        }
    }
}
