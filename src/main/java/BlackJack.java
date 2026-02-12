import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {

    BlackJackDeck deck;
    int deckPosition;
    ArrayList<BlackJackCard> userHand;
    ArrayList<BlackJackCard> computerHand;
    StringBuilder handString = new StringBuilder();
    int userTotal;
    int computerTotal;
    boolean computerStuck = false;

    BlackJack(BlackJackDeck deck, Scanner scanner) {

        // set-up game
        this.deck = deck;
        initialiseGame();

        // extra draw phase
        userStickOrTwistLoop(scanner);
        computerStickOrTwist();

        // decide winner
        decideWinner();

    }

    private void initialiseGame() {
        // shuffles deck.
        this.deck.shuffle();
        // keeps track of what card is next
        deckPosition = 0;

        // draw hands
        initialUserDraw();
        initialComputerDraw();
        printGame();
    }

    private BlackJackCard drawCard() {
        this.deckPosition++;
        return this.deck.getNextCard(this.deckPosition-1);

    }

    private void initialUserDraw() {
        userHand = new ArrayList<>(Arrays.asList(this.drawCard(), this.drawCard()));
        userTotal = countCardTotal("user");
    }

    private void initialComputerDraw() {
        computerHand = new ArrayList<>(Arrays.asList(this.drawCard(), this.drawCard()));
        computerTotal = countCardTotal("computer");
    }

    private String printHand(String player) {

        // hand we're using
        ArrayList<BlackJackCard> hand;

        // reset StringBuilder
        handString.setLength(0);

        // changes output depending on hand we are printing
        // computers first card needs to remain hidden
        if (player.equals("user")) {
            hand = userHand;
            handString.append("Your hand contains: ");
            handString.append(hand.get(0).printFace(hand.get(0).getFace()) + " of " + hand.get(0).printSuit(hand.get(0).getSuit()) + ", ");
        } else {
            hand = computerHand;
            handString.append("The computer's hand contains: ");
            // if this isn't the final summary, hide the computer's first card
            handString.append((computerStuck) ? (hand.get(0).printFace(hand.get(0).getFace()) + " of " + hand.get(0).printSuit(hand.get(0).getSuit()) + ", ") : "_____ of _____, ");
        }


        for (int i = 1; i < hand.size(); i++) {
            handString.append(hand.get(i).printFace(hand.get(i).getFace()) + " of " + hand.get(i).printSuit(hand.get(i).getSuit()) + ", ");
        }

        return handString.toString();
    }

    private void printGame() {
        System.out.printf("""
                
                --------------------------------------------------------------------------------
                %s
                
                %s
                --------------------------------------------------------------------------------
                
                """, printHand("computer"), printHand("user"));
    }


    private void userStickOrTwistLoop(Scanner scanner) {

        String userChoice;

        do {
            System.out.print("Would you like to stick or twist (s or t)?: ");
            userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("s")) {
                break;
            }
            else if (userChoice.equalsIgnoreCase("t")) {
                userHand.add(drawCard());
                userTotal = countCardTotal("user");
                printGame();

                if (checkBust("user")) {
                    System.out.println("You are bust!");
                }
            }
            else {
                System.out.println("Please enter 's' or 't'.");
            }
        } while (!checkBust("user"));
    }

    private void computerStickOrTwist() {

        computerTotal = countCardTotal("computer");

        while (computerTotal < 18) {
            computerHand.add(drawCard());
            computerTotal = countCardTotal("computer");
        }
        // computer's hand will no longer change
        computerStuck = true;
    }

    private int countCardTotal(String player) {

        ArrayList<BlackJackCard> hand = (player.equals("user")) ? userHand : computerHand;
        int total = 0;
        int aceCount = 0;

        for (BlackJackCard card : hand) {
            if (card.getFace() > 9) {
                total += 10;
            }
            else if (card.getFace() == 1) {
                aceCount++;
                total += 11;
            }
            else{
                total += card.getFace();
            }
        }

        // if bust and has aces, switch aces from value of 11 to 1
        while (total > 21 && aceCount > 0) {
            aceCount--;
            total -= 10;
        }
        return total;
    }

    private boolean checkBust(String player) {

        // chose whose hand is being checked
        int total = (player.equals("user")) ? userTotal : computerTotal;

        return total > 21;
    }

    private void decideWinner() {

        printGame();

        System.out.println((checkBust("user") ? "You are Bust!" : "Your total is: " + userTotal));
        System.out.println((checkBust("computer") ? "The computer is Bust!" : "The computer's total is: " + computerTotal));

        if (checkBust("user") || (computerTotal > userTotal && !checkBust("computer"))) {
            System.out.println("You Lose, Too bad!");
        }
        // the user cannot be bust and pass the if statement
        else if (computerTotal == userTotal) {
            System.out.println("It's a tie!");
        }
        else {
            System.out.println("Congratulations, You win!");
        }
    }


}
