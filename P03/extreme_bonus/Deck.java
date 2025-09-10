import java.util.Random;
import java.util.ArrayList;

public class Deck {
    public void addCard(Card card) {
        cards.add(card);
    }
    public Card deal() {
        return cards.get(random.nextInt(cards.size()));
    }
    @Override
    public String toString() {
        String result = "";
        for(Card card: cards) result += card.getTerm() +  '\n';
        return result;
    }
    private ArrayList<Card> cards = new ArrayList<>();
    private Random random = new Random();
}
