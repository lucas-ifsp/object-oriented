import class04.statics.Card;
import class04.statics.TriangleUtils;

void main() {
    double sideA = 3.0;
    double sideB = 4.0;

    double hypotenuse = TriangleUtils.calculateHypotenuse(sideA, sideB);

    System.out.println("The hypotenuse is: " + hypotenuse);

    // Both the method cos() and the variable (constant) PI are static
    double cosOfPi = Math.cos(Math.PI);
    System.out.println("Cosine of PI: " + cosOfPi);

    //Card card = new Card(Card.Rank.ACE, Card.Suit.DIAMONDS); // conventional constructor is not available
    final Card firstCard = Card.of(Card.Rank.ACE, Card.Suit.DIAMONDS); // creates an Ace of Diamonds in the memory
    final Card secondCard = Card.of(Card.Rank.ACE, Card.Suit.DIAMONDS); // returns the same instance create above
    final Card thirdCard = Card.closed(); // creates a closed card
}