package class06.injection;
import java.util.StringJoiner;

public class CsvEmployeeFormatter implements EmployeeFormatter {
    @Override
    public String format(Employee[] employees) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Employee e : employees)
            joiner.add(STR."\{e.getName()},\{e.getName()},\{e.getDateOfEmployment()},\{e.getYearsOfService()}");
        return joiner.toString();
    }
}
