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

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Snap");
            System.out.println("2. Blackjack");
            System.out.println("3. Rules for Snap");
            System.out.println("4. Rules for Blackjack");
            System.out.println("5. Sort Deck");
            System.out.print("Enter your choice (1–5): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
                //              int value = Integer.parseInt(input);
                if (choice >= 1 && choice <= 5) {
                    //              return choice;
                    switch (choice) {
                        case 1 -> new Snap();
                        case 2 -> new BlackJack(new Deck(), scanner);
                        case 3 -> Snap.rules();
                        case 4 -> BlackJack.rules();
                        case 5 -> sortMenu();
                        default -> System.out.println();
                    }
                }
                else {
                    continue;
                }
            } catch (NumberFormatException ignored) {
                System.out.print("Invalid input. Please enter a valid number: ");
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

        try {
            int choice = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        //deck.sortValSuit();
                        break;
                    case 2:
                        //deck.sortRValSuit();
                        break;
                    case 3:
                        //deck.sortSuitVal();
                        break;
                    case 4:
                        //deck.sortRSuitVal();
                        break;
                    default:
                        break;
                }

                System.out.println("\nDeck sorted successfully!");
                System.out.printf(deck.toString());
            }
        }
        catch (Exception e) {
            System.out.print("Invalid input. Please enter a valid number: ");
        }
    }
}
