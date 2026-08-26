package class03.exercicio;

public class Card {
    public enum Rank {FOUR, FIVE, SIX, SEVEN, QUEEN, JACK, KING, ACE, TWO, THREE}
    public enum Suit {HEARTS, SPADES, CLUBS, DIAMONDS}

    private final Rank rank;
    private final Suit suit;
    private boolean isFolded;

    public Card(Rank rank, Suit suit, boolean isFolded) {
        this.rank = rank;
        this.suit = suit;
        this.isFolded = isFolded;
    }

    public void openCard(){
        isFolded = false;
    }

    public void foldCard(){
        isFolded = true;
    }

    public String getStateAsString(){
        return "[" + suit + ", " + rank + "]" + " is " + (isFolded? "folded" : "open");
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFolded() {
        return isFolded;
    }
}
