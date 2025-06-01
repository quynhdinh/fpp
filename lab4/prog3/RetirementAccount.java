package prog3;

import employeeinfo.Account;
import employeeinfo.AccountType;
import employeeinfo.Employee;

public class RetirementAccount extends Account {
    private final double PENALTY_PERCENT = 2.0;

    public RetirementAccount(Employee e, double balance) {
        super(e, balance);
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        double bal = getBalance();

        double penalty = bal * (PENALTY_PERCENT / 100);
        bal = bal - amount - penalty;
        if (bal < 0) {
            return false;
        }
        setBalance(bal);
        return true;
    }


    @Override
    public AccountType getAccountType() {
        return AccountType.RETIREMENT;
    }
}
