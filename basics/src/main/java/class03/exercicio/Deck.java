package class03.exercicio;

public class Deck {
    private final Card[] deck = new Card[52];
    private int position;


    public Deck() {
        for(Card.Rank rank : Card.Rank.values())
            for(Card.Suit suit : Card.Suit.values()){
                deck[position++] = new Card(suit, rank);
            }
    }

    public Card takeOne(){
        return deck[--position];
    }

    public Card[] takeMany(int numberOfCards){
        Card[] cards = new Card[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            cards[i] = takeOne();
        }
        return cards;
    }
}
