package doo.tes;

public class ExternalApiClient {
    private final CheckingAccountFacade facade;

    public ExternalApiClient() {
        this.facade = new CheckingAccountFacade();
    }

    public void deposit(String account, String branch, String password, double amount) {
        facade.deposit(account, branch, password, amount);
    }

    public void withdraw(String srcAccount, String srcBranch, String password, String destAccount, String destBranch, double amount) {
        facade.withdraw(srcAccount, srcBranch, password, destAccount, destBranch, amount);
    }
}
