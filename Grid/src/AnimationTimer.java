public class AnimationTimer {

    /**
     * Cause the program to pause for the specified number of milliseconds
     * before continuing with the next statement.
     * 
     * @param millis the number of ms to wait.
     */
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            // nothing to do - just continue
        }
    }
}
