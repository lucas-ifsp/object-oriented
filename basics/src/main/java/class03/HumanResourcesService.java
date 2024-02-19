package class03;

import class03.Employee;

public class HumanResourcesService {
    void main(){
        // Declares the variable and instantiates the object using "new" keyword. Also, sets the object state.
        Employee employeeToHire = new Employee("SC303234", "Alan Turing",  "Jr. Software Engineer", 9000.0, 5);
        employeeToHire.increaseSalary(10.0);
        System.out.println(employeeToHire.getSalary());

        //only declare the variable of type Employee
        Employee otherEmployee;
        otherEmployee = new Employee(); // instantiate the object with default state
        otherEmployee.increaseSalary(2000);
        System.out.println(otherEmployee.getSalary());

        Employee[] staff = new Employee[3]; // Creates an array to refer to point to instances. All elements in the array point to null
        staff[0] = new Employee("SC323234", "John von Neumann", "Staff Engineer", 25340.99, 25);
        System.out.println(staff[0].calculateBonus()); // 3801.1485

        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "class03.Employee.calculateBonus()" because "staff[1]" is null
        //System.out.println(staff[1].calculateBonus());

        Computer newEmployeeComputer = new Computer("2321312", "Dell XPS 43", employeeToHire);
        employeeToHire.setComputer(newEmployeeComputer);

        System.out.println(employeeToHire.getComputer().getBrand()); // employeeToHire => newEmployeeComputer => 'brand' attribute: Dell XPS 43
        System.out.println(newEmployeeComputer.getEmployee().getName()); // newEmployeeComputer -> employeeToHire -> 'name' attribute: Alan Turing

        Department department = new Department("Computer Science");
        department.addEmployee(employeeToHire);
    }
}
