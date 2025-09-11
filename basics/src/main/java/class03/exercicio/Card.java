package class03.exercicio;

public class Card {
    private final Rank rank;
    private final Suit suit;
    private boolean faceUp;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void cover(){
        faceUp = false;
    }

    public void show(){
        faceUp = true;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
