package doo.tes;

import doo.CheckingAccount;
import doo.CheckingAccountRepository;

import java.util.Optional;

public class AWSCheckingAccountRepository implements CheckingAccountRepository {
    @Override
    public Optional<CheckingAccount> findOne(String accountNumber, String accountBranch) {
        return Optional.empty();
    }

    @Override
    public void update(CheckingAccount account) {

    }
}
