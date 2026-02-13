import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CardTest {

    Card card = new Card(1, 1);

    // printFace tests
    @Test
    @DisplayName("Test printFace() for 2")
    void printFace2Test() {
        String result = card.printFace(2);
        Assertions.assertTrue(result.equals("2"));
    }

    @Test
    @DisplayName("Test printFace() for 1")
    void printFaceAceTest() {
        String result = card.printFace(1);
        Assertions.assertTrue(result.equals("Ace"));
    }

    @Test
    @DisplayName("Test printFace() for 11")
    void printFaceJackTest() {
        String result = card.printFace(11);
        Assertions.assertTrue(result.equals("Jack"));
    }

    @Test
    @DisplayName("Test printFace() for 12")
    void printFaceQueenTest() {
        String result = card.printFace(12);
        Assertions.assertTrue(result.equals("Queen"));
    }

    @Test
    @DisplayName("Test printFace() for 13")
    void printFaceKingTest() {
        String result = card.printFace(13);
        Assertions.assertTrue(result.equals("King"));
    }

    @Test
    @DisplayName("Test printFace() for -1")
    void printFaceNegativeNumberTest() {
        String result = card.printFace(-1);
        Assertions.assertTrue(result.equals(""));
    }

    @Test
    @DisplayName("Test printFace() for 10000")
    void printFaceExtremeIntegerTest() {
        String result = card.printFace(10000);
        Assertions.assertTrue(result.equals(""));
    }



    // printSuit
    @Test
    @DisplayName("Test printSuit() for 0")
    void printSuitClubTest() {
        String result = card.printSuit(0);
        Assertions.assertTrue(result.equals("Clubs"));
    }

    @Test
    @DisplayName("Test printSuit() for 1")
    void printSuitDiamondsTest() {
        String result = card.printSuit(1);
        Assertions.assertTrue(result.equals("Diamonds"));
    }

    @Test
    @DisplayName("Test printSuit() for 2")
    void printSuitHeartsTest() {
        String result = card.printSuit(2);
        Assertions.assertTrue(result.equals("Hearts"));
    }

    @Test
    @DisplayName("Test printSuit() for 3")
    void printSuitSpadesTest() {
        String result = card.printSuit(3);
        Assertions.assertTrue(result.equals("Spades"));
    }

    @Test
    @DisplayName("Test printSuit() for -1")
    void printSuitNegativeNumberTest() {
        String result = card.printSuit(-1);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test printSuit() for 0")
    void printSuitExtremeNumberTest() {
        String result = card.printSuit(10000);
        Assertions.assertTrue(result.isEmpty());
    }



    // getters
    @Test
    @DisplayName("Test getFace for constructor (1, 1)")
    void testgetFaceFor1() {
        Assertions.assertTrue(card.getFace() == 1);
    }

    @Test
    @DisplayName("Test getFace for constructor (1, 1)")
    void testgetSuitFor1() {
        Assertions.assertTrue(card.getSuit() == 1);
    }
}
