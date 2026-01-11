package class06.injection;
import java.util.StringJoiner;

public class CsvEmployeeFormatter implements EmployeeFormatter {
    @Override
    public String format(Employee[] employees) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Employee e : employees)
            joiner.add(String.join(", ", e.getName(), String.valueOf(e.getDateOfEmployment()), String.valueOf(e.getYearsOfService())));
        return joiner.toString();
    }
}
