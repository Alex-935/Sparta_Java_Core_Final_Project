public class Snap {
    List<Card> p1;
    List<Card> com;
    List<Card> table;





    public void split(Player p1, Player p2) {
        // Alternating split between two players
        boolean toggle = true;

        for (Card c : cards) {
            if (toggle) p1.add(c);
            else p2.add(c);

            toggle = !toggle;
        }
}
