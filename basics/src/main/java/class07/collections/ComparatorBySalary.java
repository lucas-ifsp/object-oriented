package class07.collections;

import java.util.Comparator;

public class ComparatorBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary()); // the same as Double.valueOf(d1).compareTo(Double.valueOf(d2))
    }
}
