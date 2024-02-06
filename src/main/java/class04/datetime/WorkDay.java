package class04.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WorkDay {
    private LocalDateTime checkIn, checkOut;

    public void checkIn(LocalDateTime checkIn){
        this.checkIn = checkIn;
    }

    public void checkOut(LocalDateTime checkOut){
        this.checkOut = checkOut;
    }

    public long getWorkedTimeInMinutes(){
        if(checkIn == null || checkOut == null) return 0;
        return Duration.between(checkIn, checkOut).toMinutes();
    }
}
