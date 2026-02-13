import java.util.concurrent.ThreadLocalRandom;

/*
 *  Neuro accessibility feature that handles delay timing for turn pacing
 *  In Snap the time to react can be impacted by neural and motor impairments
 *  For future development, consider adding voice input
 */
public class SnapDelayTimer {

    // Default is now random
    private long delayMs = generateRandomDelay();

    /*
     * Generates a random delay between 400 and 1500 ms
     */
    private long generateRandomDelay() {
        // Random option preserved, but made realistically typable for console input
        return ThreadLocalRandom.current().nextLong(1200, 3501);
    }

    /*
     * Sets delay based on a chosen speed option (between cases 1 and 4)
     * Default set to random
     */
    public void setDelayByChoice(int choice) {
        // Neutral mapping of speed choice to delay values
        if (choice == 1) delayMs = 3500;                 // Slow (console-typable)
        else if (choice == 2) delayMs = 2500;            // Medium (console-typable)
        else if (choice == 3) delayMs = 1500;            // Fast (still typable)
        else if (choice == 4) delayMs = generateRandomDelay(); // Random
        else delayMs = generateRandomDelay();            // Default now random

        System.out.println("DEBUG: setDelayByChoice(" + choice + ") -> " + delayMs + "ms");
    }

    /*
     * Displays a simple countdown based on the configured delay
     */
    public void showCountdown() {

        if (delayMs <= 0) return;

        long endTime = System.currentTimeMillis() + delayMs;

        while (true) {
            long remaining = endTime - System.currentTimeMillis();
            if (remaining <= 0) break;

            System.out.println("Time left: " + remaining + "ms");

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Time left: 0ms");
    }

    /*
     * Returns the currently configured delay (cases 1 to 4)
     */
    public long getDelayMs() {
        return delayMs;
    }
}
