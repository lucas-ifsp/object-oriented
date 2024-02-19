package class03;

public class Employee {
    private String employeeId;
    private String name;
    private String jobTitle;
    private double salary;
    private int yearsOfService;
    private Computer computer;

    //default constructor
    public Employee() {
    }

    public Employee(String employeeId, String name, String jobTitle, double salary, int yearsOfService) {
        this(employeeId, name, jobTitle, salary, yearsOfService, null);
    }

    //canonical constructor
    public Employee(String employeeId, String name, String jobTitle, double salary, int yearsOfService, Computer computer) {
        this.employeeId = employeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.yearsOfService = yearsOfService;
        this.computer = computer;
    }

    void increaseSalary(double percentage){
        int salaryIncrease = (int) (salary * (percentage / 100));
        increaseSalary(salaryIncrease); // it is possible to reuse other method overload implementation
    }

    public void increaseSalary(int amount){
        if(!isValidAmount(amount)) return;
        salary += amount;
    }

    private boolean isValidAmount(int amount){
        return amount >= 0;
    }

    // Invalid: the method signature is already in use
    /*double increaseSalary(double amount){
        salary += amount;
    }*/

    double calculateBonus(){
        double bonusPercentage = 0.05; // 5% bonus for all employees
        if (yearsOfService >= 5) {
            bonusPercentage += 0.1; // Additional 10% bonus for employees with 5 or more years of service
        }
        return salary * bonusPercentage;
    }

    //  There is no setter method for employeeId, since it forbid to change it.
    public String getEmployeeId() {
        return employeeId;
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

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = Math.max(yearsOfService, 0); // Avoid a negative value for yearsOfService
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
