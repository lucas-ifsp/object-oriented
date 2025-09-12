package practical;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Course {
    public enum Room {C102, C104, C105, C106, C107, C209}
    private static int idCount;

    private int id;
    private String code;
    private DayOfWeek dayOfWeek;
    private String name;
    private String professor;
    private LocalTime startTime;
    private LocalTime endTime;
    private Room room;

    public Course(String code, DayOfWeek dayOfWeek, String name, String professor,
                  LocalTime startTime, LocalTime endTime, Room room) {
        if (!isValid(code, dayOfWeek, name, professor, startTime, endTime, room)) return;
        this.id = ++idCount;
        this.code = code;
        this.dayOfWeek = dayOfWeek;
        this.name = name;
        this.professor = professor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }

    private boolean isValid(String code, DayOfWeek dayOfWeek, String name,
                            String professor, LocalTime startTime, LocalTime endTime, Room room) {
        if(code == null || code.isBlank()) return false;
        if(name == null || name.isBlank()) return false;
        if(professor == null || professor.isBlank()) return false;
        if(startTime == null || endTime == null || !startTime.isBefore(endTime)) return false;
        return room != null;
    }

    public String getStateAsString() {
        var formatter = DateTimeFormatter.ofPattern("mm:ss");
        return String.format("| id = %d | %s (%s) | %s | Start = %s | End = %s | %s | Room = %s |",
                id, name, code, dayOfWeek, formatter.format(startTime), formatter.format(endTime), professor, room);
    }

    public int getWeeklyDurationInMinutes() {
        return (int) Duration.between(startTime, endTime).toMinutes();
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public String getProfessor() {
        return professor;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Room getRoom() {
        return room;
    }
}
