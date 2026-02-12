public class Card {
    private String suit; //0 = clubs 1=diamonds 2 = hearts 3 = spades
    private String face;

    public Card(int s , int f){
        switch (s) {
            case 0 -> setSuit("clubs");
            case 1 -> setSuit("diamonds");
            case 2 -> setSuit("hearts");
            case 3 -> setSuit("spades");
        }
        switch (f) {
            case (1-10) -> setFace(Integer.toString(f));
            case 11 -> setFace("jack");
            case 12 -> setFace("queen");
            case 13 -> setFace("king");
        }
    }

    @Override
    public String toString(){
        return ("The current card is the " + this.face + " of " + this.suit);
    }

    public String getFace() {
        return face;
    }

    private void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    private void setSuit(String suit) {
        this.suit = suit;
    }


}
