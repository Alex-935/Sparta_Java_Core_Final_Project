public class Card {
    private int suit; //0 = clubs 1=diamonds 2 = hearts 3 = spades
    private int face;

    public Card(int s , int f){
            this.suit = s;
            this.face = f;
        }

    }

    @Override
    public String toString(){
        return ("The current card is the " + printFace(this.face) + " of " + printSuit(this.suit);
    }


    public String printFace(int f){
        switch (f) {
            case (1-10) -> return Integer.toString(f);
            case 11 -> return("jack");
            case 12 -> return("queen");
            case 13 -> return("king");
        }
    }

    public String printSuit(int s){
        switch (s) {
            case 0 -> return ("clubs");
            case 1 -> return ("diamonds");
            case 2 -> return ("hearts");
            case 3 ->  return ("spades");
    }

    public String getFace() {return face;
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
