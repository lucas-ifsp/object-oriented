package doo;

import java.util.Optional;

public interface CheckingAccountRepository {
    Optional<CheckingAccount> findOne(String accountNumber, String accountBranch);
    void update(CheckingAccount account);
}
