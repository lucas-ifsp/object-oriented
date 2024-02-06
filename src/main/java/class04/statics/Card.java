package class04.statics;

public class Card {
    public enum Suit {HIDDEN, DIAMONDS, SPACES, CLUBS, HEARTS}
    public enum Rank {HIDDEN, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, QUEEN, JACK, KING}

    private static final Card[] cache = new Card[41];
    private final Suit suit;
    private final Rank rank;

    private Card(Rank rank, Suit suit) { // can not be access outside the class
        this.rank = rank;
        this.suit = suit;
    }

    public static Card of(Rank rank, Suit suit) { // perform business logic and control instance creation
        if (rank == Rank.HIDDEN ^ suit == Suit.HIDDEN) return null;
        return fromCache(rank, suit);
    }

    public static Card closed() { // provide more descriptive construction method name
        return fromCache(Rank.HIDDEN, Suit.HIDDEN);
    }

    private static Card fromCache(Rank rank, Suit suit) {
        int rankValue = rank.ordinal();
        int suitValue = suit.ordinal();
        int cachePosition = rankValue == 0 || suitValue == 0 ? 0 : (rankValue - 1) * 4 + suitValue;

        if (cache[cachePosition] == null) cache[cachePosition] = new Card(rank, suit);
        return cache[cachePosition];
    }
}
