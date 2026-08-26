package class03.exercicio;

public class Deck {
    private final Card[] cards = new Card[40];
    private int qtdCards;

    public Deck() {
        for(Card.Rank rank : Card.Rank.values()){
            for(Card.Suit suit : Card.Suit.values()) {
                cards[qtdCards++] = new Card(rank, suit, true);
            }
        }
    }

    public Card pickCard(){
        final Card card = cards[qtdCards - 1];
        cards[qtdCards - 1] = null;
        qtdCards--;
        return card;
    }

    public Card[] pickCard(int amount){
        final Card[] result = new Card[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = pickCard();
        }
        return result;
    }
}
