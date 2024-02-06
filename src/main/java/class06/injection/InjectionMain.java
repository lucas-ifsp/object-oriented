import class06.injection.*;

import java.time.LocalDate;

void main() {
    Employee[] employees = {
        new Employee("Claude Shannon", LocalDate.parse("1940-01-27"), LocalDate.parse("1916-04-30")),
        new Employee("Edsger Dijkstra", LocalDate.parse("1958-03-17"), LocalDate.parse("1930-05-11")),
        new Employee("David Huffman", LocalDate.parse("1938-11-22"), LocalDate.parse("1925-07-09"))
    };

    EmployeeFormatter formatter = new CsvEmployeeFormatter(); // ClassName<Type> varName = new ClassName<>(parameters)
    Exporter exporter = ExporterFactory.forProductionEnvironment();

    EmployeeReportService reportService = new EmployeeReportService(exporter, formatter);
    reportService.createReport(employees, "legends.csv");
}