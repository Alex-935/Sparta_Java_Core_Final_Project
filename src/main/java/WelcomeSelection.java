import java.util.Scanner;

public class WelcomeSelection {

    private final Scanner scanner = new Scanner(System.in);

    private final Deck deck = new Deck();   // initialise deck/cards = new Deck()

    public WelcomeSelection() {

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
                //              int value = Integer.parseInt(input);
                if (choice >= 1 && choice <= 5) {
                    //              return choice;
                }
                System.out.print("Invalid input. Please enter a valid number: ");

                switch (choice) {
                    case 1 -> new Snap();
                    case 2 -> new BlackJack();
                    //           case 3 -> Rules.showSnapRules();
                    //           case 4 -> Rules.showBlackjackRules();
                    case 5 -> sortMenu();
                    default -> System.out.println();
                }
            } catch (NumberFormatException ignored) {
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
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> deck.sortValSuit();
                case 2 -> deck.sortRValSuit();
                case 3 -> deck.sortSuitVal();
                case 4 -> deck.sortRSuitVal();
            }

            System.out.println("\nDeck sorted successfully!");
            System.out.println(deck.toString());
        }
        catch (Exception e) {

        }
    }
}
