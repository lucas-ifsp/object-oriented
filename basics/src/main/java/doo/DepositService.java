package doo;

import java.math.BigDecimal;
import java.util.Optional;

public class DepositService {
    private final CheckingAccountRepository repository;
    private final AuthenticationService authService;

    public DepositService(CheckingAccountRepository repository, AuthenticationService authService) {
        this.repository = repository;
        this.authService = authService;
    }

    public boolean deposit(DepositRequestModel request) {
        if(!authService.authenticate(request.accountNumber(), request.accountBranch(), request.password()))
            return false;

        final CheckingAccount account = repository.findOne(request.accountBranch(), request.accountNumber())
                .orElseThrow(() -> new IllegalStateException("Checking account is not available!"));

        account.deposit(request.amount());
        repository.update(account);
        return true;
    }
}

