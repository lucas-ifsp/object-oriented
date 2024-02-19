import class07.collections.Employee;
import class07.collections.TechnicalSkill;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

void main() {
    final List<Employee> employees = List.of(
            new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now()),
            new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)),
            new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)),
            new Employee("04", "John von Neumann", "Polymath", 35_400.0, LocalDate.now().minusYears(7)));

    System.out.println(imperativeFilterComputerScientists(employees));
    System.out.println(declarativeFilterComputerScientists(employees));



    final String[] skillNames = {"Java", "Object-orientation", "functional programming"};
    Stream.of(skillNames)
            .map(String::toUpperCase) // particular
            .map(TechnicalSkill::new) //constructor
            .sorted(Comparator.comparing(TechnicalSkill::getSkillName)) // particular
            .forEach(System.out::println);
}

public List<Employee> imperativeFilterComputerScientists(List<Employee> employees){
    final List<Employee> filtered = new ArrayList<>();
    for (Employee employee : employees) {
        if(employee.getJobTitle().equals("Computer Scientist")){
            filtered.add(employee);
        }
    }
    return filtered;
}

public List<Employee> declarativeFilterComputerScientists(List<Employee> employees){
    return employees.stream().filter(e -> e.getJobTitle().equals("Computer Scientist")).toList();
}

public double imperativeAverageSalary(List<Employee> employees){
    if(employees.isEmpty()) return 0;
    double sumOfSalaries = 0;
    for (Employee employee : employees) {
        sumOfSalaries += employee.getSalary();
    }
    return sumOfSalaries / employees.size();
}

public double declarativeAverageSalary(List<Employee> employees){
    return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
}

public void imperativePrintEmployeesHiredBeforeLastYear(List<Employee> employees){
    for (Employee employee : employees) {
        if(employee.getYearsOfService() > 1){
            System.out.println(employee);
        }
    }
}

public void declarativePrintEmployeesHiredBeforeLastYear(List<Employee> employees) {
    employees.stream().filter(e -> e.getYearsOfService() > 1).forEach(e -> System.out.println(e));
}

public Set<TechnicalSkill> imperativeCompanySkills(List<Employee> employees){
    Set<TechnicalSkill> allSkills = new HashSet<>();
    for (Employee employee : employees) {
        allSkills.addAll(employee.getSkills());
    }
    return allSkills;
}

public Set<TechnicalSkill> declarativeCompanySkills(List<Employee> employees){
    return employees.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.toSet());
}

