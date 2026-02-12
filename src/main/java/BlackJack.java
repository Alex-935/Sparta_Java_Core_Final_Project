public class BlackJack {

    String[] deck = new String[52];
            // suit c, d, h, s
            // face 1 -> 13
    String[] suit = new String[] {"clubs", "diamonds", "hearts", "spades"};
    String[] face = new String[] {"ace", "2", "3", "4", "5", "6", "8", "9", "10", "jack", "queen", "king"};

    BlackJack() {

        for (int suit = 0; suit < 4; suit++) {
            for (int face = 0; face < 13; face++) {
                deck[(suit * 13) + face] = face + " of " + suit;
            }
        }

        for (String card : deck) {
            System.out.println(card);
        }

    }
}
