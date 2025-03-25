package doo;

public class AuthenticationService {
    private final AuthenticationRepository repository;

    public AuthenticationService(AuthenticationRepository repository) {
        this.repository = repository;
    }

    public boolean authenticate(String accountNumber, String accountBranch, String password) {
        AccountCredentials credentials = repository.findOne(accountNumber, accountBranch);
        if (credentials == null) return false;
        return credentials.password().equals(password);
    }
}
