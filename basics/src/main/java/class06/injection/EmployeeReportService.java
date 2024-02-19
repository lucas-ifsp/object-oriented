package class06.injection;

public class EmployeeReportService {
    public final Exporter exporter;
    public final EmployeeFormatter formatter;

    public EmployeeReportService(Exporter exporter, EmployeeFormatter formatter) {
        this.exporter = exporter;
        this.formatter = formatter;
    }

    public void createReport(Employee[] employees, String destination){
        final String formatted = formatter.format(employees);
        exporter.export(formatted, destination);
    }
}
