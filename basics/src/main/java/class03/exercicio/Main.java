package class03.exercicio;

public class Main {
    static void main() {
        final Deck deck = new Deck();
        System.out.println(deck.pickCard().getStateAsString());

        final Card[] cards = deck.pickCard(5);

        for (Card card : cards) {
            System.out.println(card.getStateAsString());
        }
    }
}
