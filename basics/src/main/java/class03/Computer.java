package class03;

public class Computer {
    private String serialNumber;
    private String brand;
    private Employee employee;

    public Computer() {}

    public Computer(String serialNumber, String brand, Employee employee) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.employee = employee;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
