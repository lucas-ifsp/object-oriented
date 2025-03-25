package doo.factory;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record Course(String name, String code, DayOfWeek day, LocalTime startTime, LocalTime endTime) implements Reportable{
    @Override
    public String[] toReport() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return new String[]{name, code, day.toString(), formatter.format(startTime), formatter.format(endTime)};
    }
}
