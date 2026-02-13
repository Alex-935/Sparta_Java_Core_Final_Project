import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeSelection {

    private final Scanner scanner = new Scanner(System.in);

    private final Deck deck = new Deck();   // initialise deck/cards = new Deck()

    public WelcomeSelection() {

        System.out.println("=====================================");
        System.out.println("      WELCOME TO CARD GAMES!");
        System.out.println("=====================================");
        //System.out.println("\nPlease choose an option:");
        //System.out.println("1. Snap");
        //System.out.println("2. Blackjack");
        //System.out.println("3. Rules for Snap");
        //System.out.println("4. Rules for Blackjack");
        //System.out.println("5. Sort Deck");
        //System.out.print("Enter your choice (1–5): ");

        boolean reselect = true;
        while (reselect) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Snap");
            System.out.println("2. Blackjack");
            System.out.println("3. Rules for Snap");
            System.out.println("4. Rules for Blackjack");
            System.out.println("5. Sort Deck");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1–6): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
                //              int value = Integer.parseInt(input);
                if (choice >= 1 && choice <= 6) {
                    //              return choice;
                    switch (choice) {
                        case 1 -> new Snap(1, true);
                        case 2 -> new BlackJack(new Deck(), scanner);
                        case 3 -> Snap.rules();
                        case 4 -> BlackJack.rules();
                        case 5 -> sortMenu();
                        case 6 -> reselect = false;
                        default -> System.out.println();
                    }
                }
                else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void sortMenu() {
        System.out.println("\nSORT OPTIONS:");
        System.out.println("1. Value → Suit");
        System.out.println("2. Value → Suit (Reverse)");
        System.out.println("3. Suit → Value");
        System.out.println("4. Suit → Value (Reverse)");
        System.out.print("Choose sort option (1–4): ");

        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    switch (choice) {
                        case 1 -> deck.sortValSuit();
                        case 2 -> deck.sortRValSuit();
                        case 3 -> deck.sortSuitVal();
                        case 4 -> deck.sortRSuitVal();
                        default -> System.out.print("");
                    }

                    System.out.println("\nDeck sorted successfully!");
                    System.out.printf(deck.toString());
                    break;
                }
                else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
