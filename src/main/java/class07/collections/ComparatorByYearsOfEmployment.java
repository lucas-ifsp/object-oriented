package class07.collections;

import java.util.Comparator;

public class ComparatorByYearsOfEmployment implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getYearsOfService(), e2.getYearsOfService());
    }
}
