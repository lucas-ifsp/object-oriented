package practical02;

import practical02.model.Consultant;
import practical02.model.Employee;
import practical02.model.Reseller;
import practical02.persistence.EmployeeRepository;
import practical02.persistence.InMemoryEmployeeRepository;
import practical02.service.EmployeeRegistrationService;
import practical02.service.EmployeeReportService;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        final EmployeeRepository repo = new InMemoryEmployeeRepository();
        final var registrationService = new EmployeeRegistrationService(repo);
        final var reportService = new EmployeeReportService(repo);

        registrationService.register("12312312312", "David A. Huffman", LocalDate.parse("1925-08-09"), 7000.0, null);
        registrationService.register("32132132131", "Augusta Ada Byron", LocalDate.parse("1852-11-27"), 3000.0, "12312312312");
        registrationService.register("21321321313", "Edsger Wybe Dijkstra", LocalDate.parse("1930-05-11"), 1520.0, "12312312312");
        registrationService.register("45645645646", "Alan Mathison Turing", LocalDate.parse("1912-06-23"), 780.0, "32132132131");
        registrationService.register("90219021902", "Donald Ervin Knuth", LocalDate.parse("1938-01-10"), 432.0, "45645645646");
        registrationService.register("54654654654", "Grace Murray Hopper", LocalDate.parse("1906-12-09"), 432.0, "21321321313");
        registrationService.register("65465465464", "John von Neumann", LocalDate.parse("1903-12-28"), 300.00, "45645645646");
        System.out.println(reportService.reportOf("12312312312"));
    }
}
