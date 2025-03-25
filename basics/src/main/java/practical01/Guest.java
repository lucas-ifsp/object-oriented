package practical01;

public class Guest {
    private final String ssn;
    private String name;
    private String email;

    public Guest(String ssn, String name, String email) {
        this.ssn = (ssn == null) ? "" : ssn;
        setName(name);
        setEmail(email);
    }

    public void setName(String name) {
        this.name = (name == null || name.isBlank()) ? "Default" : name;
    }

    public void setEmail(String email) {
        this.email = (email == null || email.isBlank()) ? "Default" : email;

    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
