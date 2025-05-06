package practical02.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {

    private final Set<Employee> employees;

    public Consultant(String id, String name, LocalDate birthDate, double soldValue, Consultant inCharge) {
        super(id, name, birthDate, soldValue, inCharge);
        employees = new LinkedHashSet<>();
    }

    @Override
    public double getCommission() {
        return employees.stream()
                .mapToDouble(Employee::getCommission)
                .map(value -> value * 0.3)
                .reduce(getSoldValue() * 0.15, Double::sum);
    }

    public void addEmployee(Employee employee) {
        employees.removeIf(e -> e.getId().equals(employee.getId()));
        employees.add(employee);
    }

    public Set<Employee> getEmployees(){
        return new HashSet<>(employees);
    }
}
