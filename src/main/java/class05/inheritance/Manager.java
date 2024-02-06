package class05.inheritance;

import java.time.LocalDate;

public final class Manager extends Employee { // this class can not be inherited
    private String department;

    public Manager(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment, String department) {
        setId(id);
        setName(name);
        setJobTitle(jobTitle);
        setSalary(salary);
        setDateOfEmployment(dateOfEmployment);
        this.department = department;
    }

    @Override
    public double calculateBonus(){
        double managementBonus = 0.1;
        return super.calculateBonus() + getSalary() * managementBonus;
    }

    public final double calculateProfitSharing(double profit){
        return (getYearsOfService() / 5) * profit * 0.0001;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
