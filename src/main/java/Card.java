public class Card {

    private int suit; //0 = clubs 1=diamonds 2 = hearts 3 = spades
    private int face;

    public Card(int s , int f) {
        this.suit = s;
        this.face = f;
    }

    @Override
    public String toString(){
        return ("The current card is the " + printFace(this.face) + " of " + printSuit(this.suit));
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

    public int getFace() {
        return this.face;
    }

    private void setFace(int face) {
        this.face = face;
    }

    public int getSuit() {
        return this.suit;
    }

    private void setSuit(int suit) {
        this.suit = suit;
    }


}
