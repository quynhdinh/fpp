package prog3;

import employeeinfo.Account;
import employeeinfo.AccountType;

public class SavingsAccount extends Account {

    public SavingsAccount(double balance) {
        super(balance);
        this.accountType = AccountType.SAVINGS;
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        return false;
    }

    @Override
    public double getBalance() {
        double baseBalance = super.getBalance();
        double interest = (0.25 / 100) * baseBalance;
        return baseBalance + interest;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }
}
