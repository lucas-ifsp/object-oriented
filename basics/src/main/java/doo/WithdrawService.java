package doo;

import java.util.NoSuchElementException;

public class WithdrawService {
    private final CheckingAccountRepository repository;
    private final AuthenticationService authService;

    public WithdrawService(CheckingAccountRepository repository, AuthenticationService authService) {
        this.repository = repository;
        this.authService = authService;
    }

    public boolean withdraw(WithdrawRequestModel request) {
        if(!authService.authenticate(request.sourceNumber(), request.sourceBranch(), request.password()))
            return false;

        final CheckingAccount source = repository.findOne(request.sourceNumber(), request.sourceBranch())
                .orElseThrow(() -> new IllegalStateException("Checking account is not available!"));

        final CheckingAccount destination = repository.findOne(request.sourceNumber(), request.sourceBranch())
                .orElseThrow(() -> new NoSuchElementException("Destination account is not valid!"));

        if(!source.withdraw(request.amount())) return false;
        destination.deposit(request.amount());

        repository.update(source);
        repository.update(destination);
        return true;
    }
}
