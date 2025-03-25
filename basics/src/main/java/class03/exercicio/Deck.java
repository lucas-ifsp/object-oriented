package class03.exercicio;

public class Deck {
    private final Card[] deck = new Card[52];
    private int numberOfCards = 0;

    public Deck() {

        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) {
                deck[numberOfCards++] = new Card(rank, suit, true);
            }
        }
    }

    public Card takeOne(){
        final Card card = deck[numberOfCards - 1];
        deck[--numberOfCards] = null;
        return card;
    }

    public Card[] takeMany(int number){
        Card[] cards = new Card[number];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = takeOne();
        }
        return cards;
    }
}
