import class03.exercicio.Card;
import class03.exercicio.Deck;

public class Principal {
    void main(){
        final Deck deck = new Deck();
        var oneCard = deck.takeOne();
        System.out.println(oneCard.cardAsString());

        var manyCards = deck.takeMany(3);
        for (Card card : manyCards) {
            card.faceUp();
            System.out.println(card.cardAsString());
        }
    }
}

