package prog3;

import employeeinfo.Account;
import employeeinfo.AccountType;

public class CheckingAccount extends Account {

    public CheckingAccount(double balance) {
        super(balance);
        this.accountType = AccountType.CHECKING;
    }
    @Override
    public boolean makeWithdrawal(double amount) {
        double current = this.getBalance();
        if (amount <= current) {
            this.setBalance(current - amount);
            return true;
        }
        return false;
    }

    @Override
    public double getBalance() {
        double have = super.getBalance();
        super.setBalance(Math.max(0, have - 5));
        return super.getBalance();
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}