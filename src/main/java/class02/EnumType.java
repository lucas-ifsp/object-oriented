import java.time.DayOfWeek;
import java.time.LocalDate;

void main() {
    enum MaritalStatus {SINGLE, MARRIED, DIVORCED, WIDOWED}

    MaritalStatus status = MaritalStatus.SINGLE;
    if (status == MaritalStatus.MARRIED)
        System.out.println("Stay home");
    else
        System.out.println("Go to the pub");


    LocalDate date = LocalDate.now(); // Get the current date
    DayOfWeek dow = date.getDayOfWeek(); // Get the day of week of a date
    if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY)
        System.out.println("Party time!!! \\o/");
    else
        System.out.println("Working time! =(");

}
