package practical01;

import java.time.LocalTime;

public class ReservationIdGenerator {
    private static int idCount = 10_000;

    private ReservationIdGenerator() {}

    public static String nextId(){
        final LocalTime now = LocalTime.now();
        return String.format("HT%d-%d-%d", now.getSecond(), now.getMinute(), idCount++);
    }
}

