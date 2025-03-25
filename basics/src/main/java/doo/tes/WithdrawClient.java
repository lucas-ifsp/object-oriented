package doo.tes;

import doo.*;


public class WithdrawClient {
    public boolean processWithdraw(String sourceAccount, String sourceBranch, String password, String destinationAccount, String destinationBranch, double amount) {
        // For a simple request, a client class would have to know about SEVEN classes of the provider API
        AuthenticationRepository authRepo = new PostgresAuthenticationRepository();
        CheckingAccountRepository accountRepo = new AWSCheckingAccountRepository();
        AuthenticationService authService = new AuthenticationService(authRepo);
        WithdrawService withdrawService = new WithdrawService(accountRepo, authService);

        WithdrawRequestModel request = new WithdrawRequestModel(sourceAccount, sourceBranch, password, destinationAccount, destinationBranch, amount);
        return withdrawService.withdraw(request);
    }
}

