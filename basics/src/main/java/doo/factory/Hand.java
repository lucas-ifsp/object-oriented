package doo.factory;

public class Hand {
    private enum HandState {NO_CARD, ONE_CARD, WAITING_RESPONSE}
    private Player lastBetRaiser;
    private Player eventPlayer;
    private HandPoints points;
    private HandPoints pointsProposal;
    private HandState state = HandState.NO_CARD;

    public void playFirstCard(){}
    public void playSecondCard(){}
    public void accept(){}
    public void raise(){}
    public void fold(){}
// ...
    public void folsd(){
        switch (state){
            case NO_CARD, ONE_CARD -> throw new IllegalStateException("Can't fold without a point proposal.");
            case WAITING_RESPONSE -> {
                Player opponent = opponent(eventPlayer);
                addPointsProposal(points); // entry
                setLastBetRaiser(opponent); // do
                updatePlayer(); // exit
                updateScore(opponent, points); // transition behavior
            }
        }
    }

    private void updateScore(Object opponent, HandPoints points) {

    }

    private void updatePlayer() {

    }

    private Player opponent(Player eventPlayer) {
        return eventPlayer;
    }

    private void setLastBetRaiser(Object o) {

    }

    private void addPointsProposal(Object next) {
    }
}
