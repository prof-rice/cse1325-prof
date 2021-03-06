#include "deck.h"
#include <iostream>

int main() {
    Deck deck;
    
    //deck.add_card("Reuse and extension of fields and method implementations from another class", "Inheritance"); // Conflicts with UML relationships
    //deck.add_card("Bundling data and code into a restricted container","Encapsulation");
    //deck.add_card("A data type that can typically be handled directly by the underlying hardware","Primitive Type","These were used by the primitive programmers of old");
    //deck.add_card("A data type consisting of a fixed set of constant values called enumerators","Enumerated Type","It consists of ENUMerators, savvy?");
    //deck.add_card("A template encapsulating data and code that manipulates it","Class","We use it to write classy programs!");
    //deck.add_card("An encapsulated bundle of data and code","Instance");
    deck.add_card("A block of memory associated with a symbolic name that contains an object instance or a primitive data value","Variable","The value of this may vary");
    deck.add_card("A short string representing a mathematical, logical, or machine control action","Operator");
    deck.add_card("The UML relationship shown in the diagram above", "Aggregation", "", "uml-aggregation.png");
    deck.add_card("The UML relationship shown in the diagram above", "Composition", "", "uml-composition.png");
    deck.add_card("The UML relationship shown in the diagram above", "Inheritance", "", "uml-inheritance.png");
    deck.add_card("The UML relationship shown in the diagram above", "Association", "", "uml-association.png");
    deck.add_card("The UML relationship shown in the diagram above", "Association Class", "", "uml-association-class.png");
    deck.add_false_answer("Constructor");
    deck.add_false_answer("Attribute");
    deck.add_false_answer("Friend");
    deck.add_false_answer("Override");
    
    std::cout << "Select the number of the term for each definition (-1 to exit)\n\n";
    
    std::vector<std::string> options = deck.options();
    int option;
    
    while(std::cin) {
        for(int i=0; i < options.size(); ++i) 
            std::cout << i << ") " << options[i] << std::endl;
        const Card& card = deck.deal();
        std::cout << '\n' << card << "? ";
        std::cin >> option;
        if(option < 0) break;
        std::cout << '\n' << card.attempt(options[option]) << "\n\n";
    }
}
