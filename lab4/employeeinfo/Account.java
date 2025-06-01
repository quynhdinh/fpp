package employeeinfo;

public abstract class Account {
    private final Employee emp;
    private double balance;

    public Account(Employee e, double balance) {
        this.emp = e;
        this.balance = balance;
    }

    public Account(Employee e){
        this.emp = e;
        balance = 0;
    }

    public void makeDeposit(double amount) {
        double current = this.getBalance();
        this.setBalance(current + amount);
    }

    public boolean makeWithdrawal(double amount) {
        if (amount > balance)
            return false;
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public abstract AccountType getAccountType();

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Current balance:  " + balance + ", type = " + getAccountType();
    }
}
