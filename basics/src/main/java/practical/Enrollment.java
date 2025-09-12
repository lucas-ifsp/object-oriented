package practical;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class Enrollment {
    private static int idCount;

    private int id;
    private LocalDateTime enrollmentTime;
    private boolean concluded;
    private Student student;
    private Course[] courses;
    private int qtdCourses;

    public Enrollment(Student student) {
        if (student == null || student.getId() == null) {
            concluded = true;
            return;
        }
        this.id = ++idCount;
        this.student = student;
        this.courses = new Course[20];
    }

    public boolean enroll(Course course) {
        if (course == null) return false;
        if (concluded) return false;
        if (!hasAvailableHours(course)) return false;
        if (hasCollision(course)) return false;
        courses[qtdCourses++] = course;
        return true;
    }

    private boolean hasCollision(Course course) {
        for (int i = 0; i < qtdCourses; i++) {
            Course current = courses[i];

            final boolean isSameDay = course.getDayOfWeek() == current.getDayOfWeek();
            final boolean isOverlappingEnding = course.getEndTime().isAfter(current.getStartTime());
            final boolean isOverlappingBeginning = course.getStartTime().isBefore(current.getEndTime());

            if(isSameDay && (isOverlappingEnding || isOverlappingBeginning)) return true;
        }
        return false;
    }

    private boolean hasAvailableHours(Course course) {
        return course.getWeeklyDurationInMinutes() + totalDuration() / 60 > 22;
    }

    private int totalDuration() {
        int totalDuration = 0;
        for (int i = 0; i < qtdCourses; i++) {
            totalDuration += courses[i].getWeeklyDurationInMinutes();
        }
        return totalDuration;
    }

    public void remove(Course course){
        if(course == null) return;
        if(concluded) return;
        for (int i = 0; i < qtdCourses; i++) {
            if(courses[i].getId() == course.getId()) {
                courses[i] = courses[qtdCourses - 1];
                courses[qtdCourses - 1] = null;
                qtdCourses--;
            }

        }
    }

    public String getStateAsString(){
        if(!concluded) return "Enrollment not concluded!";
        if(id == 0) return "Invalid enrollment!";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringJoiner joiner = new StringJoiner("\n");

        for (int i = 0; i < qtdCourses; i++) {
            joiner.add(courses[i].getStateAsString());
        }

        return String.format("""
                ===========================================================================
                %s
                Enrollment Time: %s
                -------------------------------------------------------------------------------------------------------------------------------
                Courses:
                %s
                ===========================================================================
                """, student.getStateAsString(), formatter.format(enrollmentTime), joiner);
    }

    public void conclude() {
        this.enrollmentTime = LocalDateTime.now();
        concluded = true;
    }

    public Student getStudent() {
        return student;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEnrollmentTime() {
        return enrollmentTime;
    }

    public boolean isConcluded() {
        return concluded;
    }
}
