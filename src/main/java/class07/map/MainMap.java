import class07.collections.Employee;

import java.security.Key;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

void main(){
    Map<String, Employee> employees = new HashMap<>(); // Map<Key, Value>
    employees.put("01", new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now()));
    employees.put("02", new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1)));
    employees.put("03", new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2)));

    System.out.println("employees.get(\"03\") = " + employees.get("03"));
    System.out.println("employees.containsKey(\"04\") = " + employees.containsKey("04")); // uses hashmap and then equals
    employees.put("03", new Employee("03", "John von Neumann", "Polymath", 35_400.0, LocalDate.now().minusYears(7))); // put or replace
    employees.replace("04", new Employee("04", "Claude Elwood Shannon", "Information Scientist", 15_300.0, LocalDate.now())); // replace or ignore

    for (String keys : employees.keySet()) System.out.println(STR."Key = \{keys}");
    for (Employee value : employees.values()) System.out.println(STR."Value = \{value}");
    for (Map.Entry<String, Employee> entry : employees.entrySet()) System.out.println(STR."Entry = \{entry}");
}
