package class06.injection;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

    public String getName() {
        return name;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
