import java.util.*;

public class Deck {

        //public String[] deck;
        private List<Card> deck = new ArrayList<>(0);
        private String[] suits = {"clubs, diamonds, hearts, spades"};
        private String[] faces = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};


        // constructor
        public Deck() {

            for (int suit = 0; suit < 4; suit++) {
                for (int face = 1; face < 14; face++) {
                    deck.add(new Card(suit, face));
                }
            }
        }

        @Override
        public String toString(){

            StringBuilder deckString = new StringBuilder();

            for (Card card: deck){
                deckString.append(card.toString());
                deckString.append("%n");
            }
            return deckString.toString();
        }

        public Card getNextCard(int currIndex) {
            return this.deck.get(currIndex);
        }

        public void shuffle() {
            Collections.shuffle(this.deck);
        }


        public void sortValSuit() {
            Comparator myComp = new ValSuitComparator();
            Collections.sort(this.deck, myComp);
        }

        class ValSuitComparator implements Comparator<Card> {
            public int compare(Card c1, Card c2) {
                //face result
                if (c1.getFace() == c2.getFace()) {
                    // face is same so suit result
                    if (c1.getSuit() < (c2.getSuit())) {
                        return -1;
                    }else if (c1.getSuit() > (c2.getSuit())){
                        return 1;
                    }
                }else if (c1.getFace() < c2.getFace()){
                    return -1;
                }else {
                    return 1;
                }
                return 0;
            }
        }



        public void sortRValSuit() {
            sortValSuit();
            Collections.reverse(this.deck);
        }

        class SuitValComparator implements Comparator<Card> {
            public int compare(Card c1, Card c2) {
                //suit result
                if (c1.getSuit() == c2.getSuit()) {
                // face is same so suit result
                    if (c1.getFace() < (c2.getFace())) {
                        return -1;
                    }else if (c1.getFace() > (c2.getFace())){
                        return 1;
                    }
                }else if (c1.getSuit() < c2.getSuit()){
                    return -1;
                }else {
                    return 1;
                }
                return 0;
            }
        }

        public void sortSuitVal() {
            Comparator myComp = new ValSuitComparator();
            Collections.sort(this.deck, myComp);
        }
        public void sortRSuitVal() {
            sortSuitVal();
            Collections.reverse(this.deck);
        }


}
//"001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013",
//                    "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113",
//                    "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213",
//                    "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313"
//"001", "101", "201", "301", "002", "102", "202", "302", "003", "103", "203", "303", "004", "104", "204", "304", "005", "105", "205", "305",
//                    "006", "106", "206", "306", "007", "107", "207", "307", "008", "108", "208", "308", "009", "109", "209", "309", "010", "110", "210", "310",
//                    "011", "111", "211", "311", "012", "112", "212", "312", "013", "113", "213", "313"
//0 = clubs 1=diamonds 2 = hearts 3 = spades
//001, 002, 003, 004, 005, 006, 007, 008, 009,010, 011, 012, 013
//101, 102, 103, 104, 105, 106, 107, 108, 109,110, 111, 112, 113
//201, 202, 203, 204, 205, 206, 207, 208, 209,210, 211, 212, 213
// 301, 302, 303, 304, 305, 306, 307, 308, 309,310, 311, 312, 313

/*
deck = new String[]{"001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013",
        "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113",
        "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213",
        "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313"};
 */