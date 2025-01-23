package be.cloudns.edebe.timesync.fabric.util;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class TimeUtil {

    public static long getMinecraftTime() {
        // 使用系统默认时区获取当前时间
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        
        // 优化计算方法：直接使用LocalTime的toSecondOfDay
        long totalSeconds = now.toSecondOfDay();
        
        // 将秒数转换为Minecraft tick (1 second = 20 ticks)
        // 3.6 = 72/20 (72 = 24 hours * 3600 seconds / 1200 minecraft hours)
        return (long) (totalSeconds / 3.6);
    }
}