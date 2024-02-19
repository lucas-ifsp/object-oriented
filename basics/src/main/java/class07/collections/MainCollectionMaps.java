import class07.collections.Employee;
import class07.collections.Paycheck;
import class07.collections.TechnicalSkill;

import java.time.LocalDate;
import java.util.*;

void main(){
    List<Employee> employees = new ArrayList<>();
    var ada = new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now());
    var dijkstra = new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2));
    var huffman = new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1));
    employees.add(ada);
    employees.add(dijkstra);
    employees.add(1, huffman);

    for (Employee employee : employees)
        System.out.println(employee);

    System.out.println("employees.size() = " + employees.size());
    employees.remove(ada);
    System.out.println("employees.contains(ada) = " + employees.contains(ada));
    System.out.println("employees.size() = " + employees.size());


    final List<Employee> immutableList = List.of(ada, dijkstra);
    final List<Employee> fixedSizeList = Arrays.asList(ada, dijkstra);

    //immutableList.add(huffman); // throws java.lang.UnsupportedOperationException
    //fixedSizeList.add(huffman); // throws java.lang.UnsupportedOperationException

    fixedSizeList.set(0, huffman);
    System.out.println(fixedSizeList.get(0)); // Employee{name='02', name='David Huffman', jobTitle='Computer Scientist, salary=10700.0, dateOfEmployment=2023-02-05}
    //immutableList.set(0, huffman);  // throws java.lang.UnsupportedOperationException

    // List.of() produces an immutable list. As it cannot be sorted, it is necessary to create an ArrayList from it.
    List<String> legendNames = new ArrayList<>(List.of("Ada", "Hopper", "von Neumann", "Turing"));
    Collections.sort(legendNames);
    final String output = String.join(", ", legendNames);
    System.out.println(output); // it prints 'Ada, Turing, Hopper, von Neumann'

    List<Integer> legendBirthYear = new ArrayList<>(List.of(1815, 1906, 1903, 1912));
    Collections.sort(legendBirthYear);
    StringJoiner joiner = new StringJoiner(", ");
    for (Integer year : legendBirthYear) {
        joiner.add(year.toString());
    }
    System.out.println(joiner); // it prints '1815, 1903, 1906, 1912'


    List<Employee> legends = new ArrayList<>();
    legends.add(new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)));
    legends.add(new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now()));
    legends.add(new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)));

    Collections.sort(legends); // Collections.reverse(legends) to sort in reverse order
    joiner = new StringJoiner("\n");
    for (Employee legend : legends) {
        joiner.add(legend.toString());
    }
    System.out.println(joiner);

    final Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
    legends.sort(bySalary);
    for (Employee legend : legends)
        System.out.println(legend);

    // The interface Comparator also has several static factory methods that create Comparator instances based on Integers, Doubles, etc.
    final Comparator<Employee> byYearsOfService = Comparator.comparingInt(Employee::getYearsOfService);
    legends.sort(byYearsOfService); // same as Comparator.comparingInt(e -> e.getYearsOfService())
    System.out.println("---");
    for (Employee legend : legends)
        System.out.println(legend);

    ada.createPaycheck(LocalDate.now().plusMonths(1));
    ada.createPaycheck(LocalDate.now());
    // ada.getPaychecks(); // this getter is not available
    final Iterator<Paycheck> paycheckIterator = ada.iteratorPaychecks();
    while (paycheckIterator.hasNext()){
        final Paycheck paycheck = paycheckIterator.next();
        System.out.println(paycheck);
    }

    final List<TechnicalSkill> technicalSkills = List.of(new TechnicalSkill("Postgres", 5), new TechnicalSkill("Java", 4), new TechnicalSkill("Bash", 3));
    final Set<TechnicalSkill> hashSet = new HashSet<>(technicalSkills);
    final Set<TechnicalSkill> treeSet = new TreeSet<>(technicalSkills);
    final Set<TechnicalSkill> linkedHashSet = new LinkedHashSet<>(technicalSkills);

    for (var skill : hashSet) {
        System.out.println(STR."HashSet = \{skill}");
    }
    for (var skill : treeSet) {
        System.out.println(STR."TreeSet = \{skill}");
    }
    for (var skill : linkedHashSet) {
        System.out.println(STR."LinkedHashSet = \{skill}");
    }
}