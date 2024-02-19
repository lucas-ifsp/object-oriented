package class06.generics;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee implements Reportable {
    private String name;
    private LocalDate dateOfEmployment;
    private LocalDate birthDate;

    //constructor
    public Employee(String name, LocalDate dateOfEmployment, LocalDate birthDate) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
        this.birthDate = birthDate;
    }

    @Override
    public String[] reportContent() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new String[]{name, dateOfEmployment.format(formatter), birthDate.format(formatter), String.valueOf(getYearsOfService())};
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
