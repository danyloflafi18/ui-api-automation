package ui.utils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class UserWaitsForResult {
    public static void timeout(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
