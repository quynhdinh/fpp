package prog3;

import employeeinfo.Account;
import employeeinfo.AccountType;
import employeeinfo.Employee;

public class SavingsAccount extends Account {

    public SavingsAccount(Employee e, double balance) {
        super(e, balance);
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
