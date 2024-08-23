import class03.exercicio.Card;
import class03.exercicio.Deck;

void main(){
    Deck deck = new Deck();
    final Card[] cards = deck.takeMany(10);
    for (Card card : cards) {
        System.out.println(card.asString());
    }
}