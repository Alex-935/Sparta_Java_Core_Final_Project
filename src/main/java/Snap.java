import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;


public class Snap {
    Deck deck;
    long delayMs;
    int deckPosition = 0;
    Stack<Card> p1 = new Stack<>();
    Stack<Card> com = new Stack<>();
    Stack<Card> table = new Stack<>();




    // empty constructor to prevent crash
    Snap(Deck deck, Scanner scanner) {
        this.deck = deck;
        this.deck.shuffle();


        System.out.println("Input delay speed: ");
        System.out.println("1.Slow");
        System.out.println("2.Medium");
        System.out.println("3.Fast");
        System.out.println("4.Random");


        delayMs = SnapDelayTimer.setDelayByChoice(scanner.nextInt());


        splitDeck();


        boolean toggle = true;


        //while p1 not empty and com not empty
        while (!p1.empty() && !com.empty()) {
            if (toggle) {
                playCard(p1);
            } else {
                playCard(com);
            }
            toggle = !toggle;


            Card topCard = table.pop();


            if (!table.empty()) {
                Card secondCard = table.pop();


                if (topCard.getFace() == secondCard.getFace()) {
                    //time delay etc etc
                    System.out.println("Faces are equal");
                    String showdownCountdown = Countdown(scanner);


                    table.push(secondCard);
                    table.push(topCard);


                    //if p1 fast
                    //
                    if (showdownCountdown.equals("p1")) {
                        System.out.println("You said snap first! Gain all cards on table");
                        for (Card card : table) {
                            p1.push(card);
                        }
                    } else {
                        //else com is faster
                        System.out.println("The computer said snap faster! It takes all the cards");
                        for (Card card : table) {
                            com.push(card);
                        }
                    }
                    table.clear();
                }else{
                    table.push(secondCard);
                    table.push(topCard);
                }
            }else {
                table.push(topCard);
            }
        }


        if (com.empty()){
            System.out.println("Com hand empty. You win!");
        }else {
            System.out.println("P1 hand empty. Computer win!");
        }


        if (toPlayAgain(scanner) == true){
            new Snap(new Deck(), scanner);
        };
    }




    private Card drawCard() {
        this.deckPosition++;
        return this.deck.getNextCard(this.deckPosition-1);


    }
    public void splitDeck() {
        //Alternating split between two players
        boolean toggle = true;


        for (int i=0; i<= 51; i++) {
            if (toggle) p1.push(drawCard());
            else com.push(drawCard());


            toggle = !toggle;
        }
    }


    public void playCard(Stack playerDeck){
        //output
        Object next = playerDeck.pop();
        System.out.println(next);
        //add onto table
        table.push((Card) next);


    }


    public String Countdown(Scanner s) {


        long endTime = System.currentTimeMillis() + delayMs;


        while (!s.next().equals("s")) {
            long remaining = endTime - System.currentTimeMillis();
            if (remaining <= 0) return "com";


            //System.out.println("Time left: " + remaining + "ms");


            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return "p1";


    }
    private boolean toPlayAgain(Scanner scanner) {


        do {
            System.out.print("Would you like to play again? ('y' or 'n'): ");
            String input = scanner.nextLine();


            if (input.equalsIgnoreCase("y")) {
                return true;
            }
            else if (input.equalsIgnoreCase("n")) {
                return false;
            }
            else {
                System.out.println("Please enter 'y' or 'n'.");
            }
        } while (true);
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
}
