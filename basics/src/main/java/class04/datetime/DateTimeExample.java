import class04.datetime.Employee;
import class04.datetime.WorkDay;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

void main() {
    final LocalDate employeeEmploymentDate = LocalDate.of(2022, 12, 1); // year, month, day
    final LocalDate birthDate = LocalDate.of(2000, Month.APRIL, 1); // year, enum value for month, day
    Employee employee = new Employee("John von Neumann", employeeEmploymentDate, birthDate);

    final LocalDate internEmploymentDate = LocalDate.parse("2020-10-30"); // ISO format
    final LocalDate internBirthDate = LocalDate.parse("2001-01-23");
    final Employee intern = new Employee("Dennis Ritchie", internEmploymentDate, internBirthDate);

    System.out.println(employee.isBirthday());
    System.out.println(intern.getYearsOfService()); // 3

    final LocalDate dayAfterOneYearSixMonthsAndFiveDays = LocalDate.now().plusYears(1).plusMonths(6).plusDays(5);
    System.out.println(dayAfterOneYearSixMonthsAndFiveDays);

    final WorkDay workDay = new WorkDay();
    workDay.checkIn(LocalDateTime.of(2024, 1, 21, 8, 2));
    workDay.checkOut(LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 59, 0))); // hour, minute, second
    final long workedTimeInMinutes = workDay.getWorkedTimeInMinutes();

    System.out.println("Worked time in minutes = " + workedTimeInMinutes); // Worked time in minutes = 537
    System.out.println("Worked time in hours = " + Duration.ofMinutes(workedTimeInMinutes).toHours()); // Worked time in hours = 8

    final LocalDateTime todayAt6AM = LocalDate.now().atTime(6, 0); // 6:00
    System.out.println(todayAt6AM.isAfter(LocalDateTime.now())); // probably not ;)

    System.out.println(todayAt6AM.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))); // 22/01/2024 06:00:00
    System.out.println(todayAt6AM.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).localizedBy(Locale.CHINA))); //2024年1月22日

    final Instant plusBegin = Instant.now();
    String result = "";
    for (int i = 0; i < 100_000; i++) {
        result += " " + i; // a new String is created in each iteration. Extremely inefficient!
    }
    final Instant plusEnd = Instant.now();

    final Instant withBuilderBegin = Instant.now();
    StringBuilder builder = new StringBuilder(); // creates an array
    for (int i = 0; i < 100_000; i++) {
        builder.append(" ").append(i); // builds the String content
    }
    String sbResult = builder.toString();
    final Instant withBuilderEnd = Instant.now();

    System.out.println("With plus = " + Duration.between(plusBegin, plusEnd).toMillis()); // 2.442.503.000
    System.out.println("With builder = " + Duration.between(withBuilderBegin, withBuilderEnd).toMillis()); // 13.111.000
}