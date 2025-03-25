package doo;

public interface AuthenticationRepository {
    AccountCredentials findOne(String accountNumber, String accountBranch) ;
}
