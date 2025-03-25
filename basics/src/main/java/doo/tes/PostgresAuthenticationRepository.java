package doo.tes;

import doo.AccountCredentials;
import doo.AuthenticationRepository;

public class PostgresAuthenticationRepository implements AuthenticationRepository {
    @Override
    public AccountCredentials findOne(String accountNumber, String accountBranch) {
        return null;
    }
}
