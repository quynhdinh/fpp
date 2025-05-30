package lab4.prog7;

public class Account implements Comparable<Account> {
    private AccountType acctType;
    private double balance;

    public Account(AccountType acctType, double balance) {
        this.acctType = acctType;
        this.balance = balance;
    }

    public void makeDeposit(double amount) {
        balance += amount;
    }

    public boolean makeWithdrawal(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public AccountType getAcctType() {
        return acctType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(Account otherAcc) {
        return Double.compare(this.balance, otherAcc.balance);
    }

    @Override
    public String toString() {
        return "Account type: " + acctType.toString().toLowerCase() + "\n" +
               "Current bal:  " + balance + "\n";
    }
}
