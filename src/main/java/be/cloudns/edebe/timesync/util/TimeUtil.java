package be.cloudns.edebe.timesync.util;

import java.time.LocalTime;
import java.time.ZoneId;

public final class TimeUtil {
    private static final long TICKS_PER_DAY = 24000L;
    private static final long SECONDS_PER_DAY = 24 * 60 * 60;

    public static long getMinecraftTime() {
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        long secondsSinceMidnight = now.toSecondOfDay();

        long adjustedSeconds = (secondsSinceMidnight - 6 * 3600 + SECONDS_PER_DAY) % SECONDS_PER_DAY;

        double ticks = adjustedSeconds * (TICKS_PER_DAY * 1.0 / SECONDS_PER_DAY);
        return (long) ticks;
    }
}