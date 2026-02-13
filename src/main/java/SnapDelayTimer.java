import java.util.concurrent.ThreadLocalRandom;

public class SnapDelayTimer {

    /*
     *  Neurodivergent accessibility feature that handles delay timing for turn pacing
     *  In Snap the time to react can be impacted by neural and motor impairments
     *  For future development, consider adding voice input
     */

    /*
     * Generates a random delay between 400 and 1500 ms
     */
    private static long generateRandomDelay() {
        // Random option preserved, but made realistically typable for console input
        return ThreadLocalRandom.current().nextLong(1200, 3501);
    }

    /*
     * Sets delay based on a chosen speed option (between cases 1 and 4)
     * Default set to random
     */
    public static long setDelayByChoice(int choice) {
        // Neutral mapping of speed choice to delay values
        // Default is now random
        long delayMs = generateRandomDelay();
        if (choice == 1) delayMs = 3500;                 // Slow (console-typable)
        else if (choice == 2) delayMs = 2500;            // Medium (console-typable)
        else if (choice == 3) delayMs = 1500;            // Fast (still typable)
        else if (choice == 4) delayMs = generateRandomDelay(); // Random
        else delayMs = generateRandomDelay();            // Default now random

        System.out.printf("DEBUG: setDelayByChoice(%d) -> %dms%n", choice, delayMs);
        return delayMs;
    }
}