import java.util.Scanner;

/*
 * Manual console runner for SnapDelayTimer
 */
public class TimerManualTest {

    public static void main(String[] args) {

        // Neutral single scanner instance for System.in
        Scanner scanner = new Scanner(System.in);
        SnapDelayTimer timer = new SnapDelayTimer();

        // Neutral prompt for a single delay selection
        System.out.println("Select delay speed:");
        System.out.println("1 = Slow");
        System.out.println("2 = Medium");
        System.out.println("3 = Fast");
        System.out.println("4 = Random");
        System.out.print("Choice: ");

        String raw = scanner.nextLine();
        System.out.println("DEBUG: raw input = [" + raw + "]");

        int choice;
        try {
            choice = Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            choice = 4; // Neutral fallback to random
        }

        System.out.println("DEBUG: parsed choice = " + choice);

        timer.setDelayByChoice(choice);

        System.out.println("Selected delay: " + timer.getDelayMs() + "ms");
        timer.showCountdown();

        scanner.close();
    }
}
