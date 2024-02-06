package class04.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String name;
    private LocalDate dateOfEmployment;
    private LocalDate birthDate;

    //constructor
    public Employee(String name, LocalDate dateOfEmployment, LocalDate birthDate) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
        this.birthDate = birthDate;
    }

    public int getYearsOfService(){
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public boolean isBirthday(){
        final LocalDate today = LocalDate.now();
        return birthDate.getDayOfMonth() == today.getDayOfMonth() && birthDate.getMonth() == today.getMonth();
    }
}
