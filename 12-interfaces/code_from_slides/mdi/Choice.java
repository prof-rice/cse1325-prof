import java.util.Random;

// String workaround for forward references *sigh*
enum Choice {Rock(    " crushes ",   "Scissors", " crushes ",     "Lizard"),
             Paper(   " covers ",    "Rock",     " disproves ",   "Spock"), 
             Scissors(" cuts ",      "Paper",    " decapitates ", "Lizard"),
             Lizard(  " poisons ",   "Spock",    " eats ",        "Paper"),
             Spock(   " vaporizes ", "Rock",     " smashes ",     "Scissors");

    private Choice(String result1, String win1, String result2, String win2) {
        this.result1 = result1;
        this.win1 = win1;  
        this.result2 = result2;
        this.win2 = win2;
    }
    public String outcome(Choice other) {
        if(other == this) return "";
        if(other.toString().equals(win1)) return this + result1 + other;
        if(other.toString().equals(win2)) return this + result2 + other;
        return null;
    }
    public static Choice random() {
        return choices[random.nextInt(choices.length)];
    }
    private String result1;
    private String win1;
    private String result2;
    private String win2;
    private static final Random random = new Random();
    private static Choice[] choices = values();
}

