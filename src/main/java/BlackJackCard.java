public class BlackJackCard {

    private int face;
    private int suit;

    public BlackJackCard(int s, int f) {
        this.suit = s;
        this.face = f;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String printFace(int f){

        return switch (f) {
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 -> Integer.toString(f);
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> "";
        };
    }

    public String printSuit(int s) {
        return switch (s) {
            case 0 -> "Clubs";
            case 1 -> "Diamonds";
            case 2 -> "Hearts";
            case 3 -> "Spades";
            default -> "";
        };
    }
}
