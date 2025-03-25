package doo;

import java.math.BigDecimal;

public class CheckingAccount {
    private final String number;
    private final String branch;
    private BigDecimal balance;

    public CheckingAccount(String number, String branch) {
        this.number = number;
        this.branch = branch;
    }

    public void deposit(double amount) {
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    public boolean withdraw(double amount) {
        final BigDecimal decimal = BigDecimal.valueOf(amount);
        if(balance.compareTo(decimal) < 0) return false;
        balance = balance.subtract(decimal);
        return true;
    }

    public double getBalance() {
        return balance.doubleValue();
    }

    public String getNumber() {
        return number;
    }

    public String getBranch() {
        return branch;
    }
}
