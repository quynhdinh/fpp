package prog1;

import employeeinfo.AccountType;

class Account {
    private final static double DEFAULT_BALANCE = 0.0;
    private double balance;
    private Enum<AccountType> acctType;
    private Employee employee;

    Account(Employee emp, Enum acctType, double balance) {
        employee = emp;
        this.acctType = acctType;
        this.balance = balance;
    }

    Account(Employee emp, Enum<AccountType> acctType) {
        this(emp, acctType, DEFAULT_BALANCE);
    }

    public String toString() {
        return "type = " + acctType + ", balance = " + balance;
    }

    public void makeDeposit(double deposit) {
        this.balance += deposit;
    }

    public boolean makeWithdrawal(double amount) {
        if (this.balance < amount) return false;
        this.balance -= amount;
        return true;
    }

    public Enum<AccountType> getAcctType() {
        return acctType;
    }

    public void setAcctType(AccountType acctType) {
        this.acctType = acctType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}