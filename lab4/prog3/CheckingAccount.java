package prog3;

import employeeinfo.Account;
import employeeinfo.AccountType;
import employeeinfo.Employee;

public class CheckingAccount extends Account {

    public CheckingAccount(Employee e, double balance) {
        super(e, balance);
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