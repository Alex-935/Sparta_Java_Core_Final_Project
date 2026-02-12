import java.util.Scanner;

public class WelcomeSelection {

    private final Scanner scanner = new Scanner(System.in);

    private final Deck deck = new Deck();   // initialise deck/cards = new Deck()

    public int start_games() {

    System.out.println("=====================================");
    System.out.println("      WELCOME TO CARD GAMES!");
    System.out.println("=====================================");
    System.out.println("\nPlease choose an option:");
    System.out.println("1. Snap");
    System.out.println("2. Blackjack");
//    System.out.println("3. Rules for Snap");
//    System.out.println("4. Rules for Blackjack");
//    System.out.println("5. Sort Deck");
    System.out.print("Enter your choice (1–2): ");

            int choice = scanner.nextInt();
            while (true) {
                try {
            catch(NumberFormatException ignored){
                    }
//              int value = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
//              return choice;
                    }
                    System.out.print("Invalid input. Please enter a valid number: ");
                }
        switch (choice) {
           case 1 -> new Snap().play();
           case 2 -> new BlackJack().play();
//           case 3 -> Rules.showSnapRules();
//           case 4 -> Rules.showBlackjackRules();
           case 5 -> sortMenu();
        }
        return (choice);
    }
        private int getValidatedInput(int min, int max) {
        }
        private void sortMenu() {
            System.out.println("\nSORT OPTIONS:");
            System.out.println("1. Value → Suit");
            System.out.println("2. Value → Suit (Reverse)");
            System.out.println("3. Suit → Value");
            System.out.println("4. Suit → Value (Reverse)");
            System.out.print("Choose sort option (1–4): ");

            int choice = getValidatedInput(1, 4);

            switch (choice) {
                case 1 -> deck.sortValSuit();
                case 2 -> deck.sortRValSuit();
                case 3 -> deck.sortSuitVal();
                case 4 -> deck.sortRSuitVal();
            }

            System.out.println("\nDeck sorted successfully!");
            System.out.println(deck.getCards());
        }
    }


