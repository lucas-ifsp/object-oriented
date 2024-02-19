package class05.inheritance;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public sealed class Employee permits Manager { // this class can only be inherited by Manager
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    public Employee() {
    }

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double calculateBonus(){
        double bonusPercentage = 0.05; // 5% bonus for all employees
        if (getYearsOfService() >= 5) {
            bonusPercentage += 0.1; // Additional 10% bonus for employees with 5 or more years of service
        }
        return salary * bonusPercentage;
    }

    public final int getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return STR."""
        Employee{name='\{id}', name='\{name}', jobTitle='\{jobTitle}, salary=\{salary}, dateOfEmployment=\{dateOfEmployment}}""";    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Objects.hash(attribute1, attribute2, ... attribute n)
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }
}
