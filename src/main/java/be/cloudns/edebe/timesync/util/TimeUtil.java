package be.cloudns.edebe.timesync.util;

import java.time.LocalTime;
import java.time.ZoneId;

public final class TimeUtil {

    public static long getMinecraftTime() {
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        long totalSeconds = now.toSecondOfDay();
        return (long) (totalSeconds / 3.6);
    }
}