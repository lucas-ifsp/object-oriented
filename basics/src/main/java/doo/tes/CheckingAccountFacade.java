package doo.tes;

import doo.*;

import java.util.Optional;

public class CheckingAccountFacade {

    private final DepositService depositService;
    private final WithdrawService withdrawService;

    public CheckingAccountFacade() {
        AuthenticationRepository authRepo = new PostgresAuthenticationRepository();
        CheckingAccountRepository accountRepo = new AWSCheckingAccountRepository();
        AuthenticationService authService = new AuthenticationService(authRepo);
        this.depositService = new DepositService(accountRepo, authService);
        this.withdrawService = new WithdrawService(accountRepo, authService);
    }

    public boolean deposit(String account, String branch, String password, double amount) {
        var request = new DepositRequestModel(account, branch, password, amount);
        return depositService.deposit(request);
    }

    public boolean withdraw(String sourceAccount, String sourceBranch, String password, String destinationAccount, String destinationBranch, double amount) {
        var request = new WithdrawRequestModel(sourceAccount, sourceBranch, password, destinationAccount, destinationBranch, amount);
        return withdrawService.withdraw(request);
    }
}
