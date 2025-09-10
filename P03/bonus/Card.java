public class Card {
    public Card(String term, String definition) {
       if(term == null || term.isEmpty()) 
           throw new IllegalArgumentException("Bad term");
       if(definition == null || definition.isEmpty()) 
           throw new IllegalArgumentException("Bad definition");
        this.definition = definition;
        this.term = term;
    }
    @Override
    public String toString() {
        return definition;
    }
    public boolean attempt(String response) {
        return response.toUpperCase().equals(term.toUpperCase());
    }
    public String getTerm() {
        return term;
    }
    
    private String definition;
    private String term;
}
