package utils;

public class RetryUtils {

    public static void retry(int attempts, Runnable action) {

        int count = 0;

        while (count < attempts) {
            try {
                action.run();
                return;
            } catch (Exception e) {
                count++;
                if (count >= attempts) {
                    throw e;
                }
            }
        }
    }
}
