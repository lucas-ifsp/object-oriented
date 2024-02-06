import class05.inheritance.Employee;
import class05.inheritance.Manager;
import class05.inheritance.TechnicalSkill;

import java.time.LocalDate;

void main() {
    LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
    Employee firstProgrammer = new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, fiveYearsAgo);
    Manager analyticalEngineer = new Manager("02", "Charles Babbage", "Computer Engineer", 10_000.0, fiveYearsAgo, "Mathematics");

    System.out.println(firstProgrammer);
    //prints Employee{id='01', name='Ada Lovelace', jobTitle='Computer Programmer', salary=10000.0, dateOfEmployment=2019-01-24}

    System.out.println(analyticalEngineer);
    //prints Employee{id='02', name='Charles Babbage', jobTitle='Computer Engineer', salary=10000.0, dateOfEmployment=2019-01-24}

    Object oneInstance = new Object();
    Object otherInstance = new Object();
    System.out.println(oneInstance.equals(otherInstance)); // false because the default implementation of equals compare memory references

    Employee turingDuringWar = new Employee("03", "Alan Turing", "Computer Scientist", 23_023.23, LocalDate.now());
    Employee turingAfterWar = new Employee("03", "Alan Turing", "Legend", 0.0, LocalDate.now());
    System.out.println(turingDuringWar.equals(turingAfterWar)); // true because the id is the same (Entity)
    System.out.println(turingDuringWar.hashCode()); // 1570
    System.out.println(turingAfterWar.hashCode()); // 1570

    Employee turingWithDifferentId = new Employee("04", "Alan Turing", "Computer Scientist", 23_023.23, LocalDate.now());
    System.out.println(turingDuringWar.equals(turingWithDifferentId)); // false, because the ids are different
    System.out.println(turingWithDifferentId.hashCode()); // 1571

    TechnicalSkill skillDuringWar = new TechnicalSkill("Theory of computation", 5);
    TechnicalSkill skillAfterWar = new TechnicalSkill("Theory of computation", 5);
    System.out.println(skillDuringWar.equals(skillAfterWar)); // true because all values are the same (Value Object)
}


