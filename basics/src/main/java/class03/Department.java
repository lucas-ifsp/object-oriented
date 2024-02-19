package class03;

public class Department {
    private String name;
    private final Employee[] staff = new Employee[10];
    private int numberOfEmployees;

    public Department(String name){
        this.name = name;
    }

    public void addEmployee(Employee employee){
        staff[numberOfEmployees++] = employee;
    }

    public void removeEmployee(Employee employee){}
    public void hasEmployee(Employee employee){}
    public Employee getEmployee(String employeeId){return null;}
}
