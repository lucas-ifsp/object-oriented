package practical;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String id;
    private String name;
    private LocalDate admissionDate;

    public Student(String id, String name, LocalDate admissionDate) {
        if (!isValidate(id, name, admissionDate)) return;
        this.id = id;
        this.name = name;
        this.admissionDate = admissionDate;
    }

    private boolean isValidate(String id, String name, LocalDate admissionDate) {
        if(id == null || id.isBlank() || ! isValidFormat(id)) return false;
        if(name == null || name.isBlank()) return false;
        return admissionDate != null && !admissionDate.isAfter(LocalDate.now());
    }

    private boolean isValidFormat(String id) {
        final String lowerCaseId = id.toLowerCase();
        if(!lowerCaseId.startsWith("sc")) return false;
        if(id.length() != 9) return false;
        final char dv = lowerCaseId.charAt(8);
        if(!Character.isDigit(dv) && dv != 'x') return false;
        final String middle = lowerCaseId.substring(2, 8);
        for (char c : middle.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }

    public int getSemester() {
        Period period = Period.between(admissionDate, LocalDate.now());
        final int months =  (int)period.toTotalMonths();
        return (months / 6) + 1;
    }

    public String getStateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s | %s | %s", id, name, formatter.format(admissionDate));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
}
