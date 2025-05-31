package prog3;

import employeeinfo.Account;
import employeeinfo.AccountType;

public class RetirementAccount extends Account {

    public RetirementAccount(double balance) {
        super(balance);
        this.accountType = AccountType.RETIREMENT;
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        double need = amount * 1.02;
        double have = super.getBalance();
        if (have >= need) {
            super.setBalance(have - need);
            return true;
        }
        return false;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.RETIREMENT;
    }
}
