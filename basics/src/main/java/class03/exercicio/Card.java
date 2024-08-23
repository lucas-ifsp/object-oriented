package class03.exercicio;

public class Card {
    public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}

    private Suit suit;
    private Rank rank;
    private boolean isClosed;

    public Card(){
        this.isClosed = true;
    }
    public Card(Suit suit, Rank rank) {
        if(suit == null ^ rank == null){
            throw new IllegalArgumentException("Foi bad.");
        }
        this.suit = suit;
        this.rank = rank;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String asString(){
        return isClosed? "[X]" : "[" + suit + ", " + rank + "]";
    }


}
