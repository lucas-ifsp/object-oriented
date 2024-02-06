package class07.collections;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private List<Paycheck> paychecks;
    private Set<TechnicalSkill> skills;

    public Employee() {}

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.skills = new HashSet<>();
        this.paychecks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return STR."""
        Employee{name='\{id}', name='\{name}', jobTitle='\{jobTitle}, salary=\{salary}, dateOfEmployment=\{dateOfEmployment}}""";}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void createPaycheck(LocalDate payday){
        paychecks.add(new Paycheck(payday, salary));
    }

    public void removePaycheck(Paycheck paycheck){
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaychecks(){
        return paychecks.iterator();
    }

    public void addSkill(TechnicalSkill skill){
        skills.add(skill);
    }

    public void removeSkill(TechnicalSkill skill){
        skills.remove(skill);
    }

    public boolean hasSkill(TechnicalSkill skill){
        return skills.contains(skill);
    }

    public Set<TechnicalSkill> getSkills(){
        return Set.copyOf(skills);
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public final int getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
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

    @Override
    public int compareTo(Employee other) {
        return id.compareTo(other.id);
    }
}
