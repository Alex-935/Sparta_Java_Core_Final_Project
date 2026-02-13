import java.util.List;

public class Snap {

    List<Card> p1;
    List<Card> com;
    List<Card> table;

    // empty constructor to prevent crash
    Snap(int i, boolean b) {
    }

    public static void rules() {
        System.out.println("""
                To play snap:
                    - Your goal is to get every card
                    - Players take in turns placing a card on the middle pile.
                    - When two cards of the same value are placed after each other, you need to say snap first.
                    - The person that says snap first, gets the whole pile.
                    - The person who runs out of cards first, loses!
                    - The person who doesn't run out of cards is the winner!
                """);
    }

    public void splitDeck() {
        //Alternating split between two players
        boolean toggle = true;

        /*for (Card c : cards) {
            if (toggle) p1.add(c);
            else com.add(c);

            toggle = !toggle;
        }*/
    }
}
