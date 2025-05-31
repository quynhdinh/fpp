package employeeinfo;

public abstract class Account {
    private double balance;
    protected AccountType accountType;

    public Account(double balance) {
        this.balance = balance;
    }

    public abstract void makeDeposit(double amount);

    public abstract boolean makeWithdrawal(double amount);

    public double getBalance(){
        return balance;
    }

    public abstract AccountType getAccountType();

    public void setBalance(double balance){
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Current balance:  " + balance + " type = " + accountType.type;
    }
}
