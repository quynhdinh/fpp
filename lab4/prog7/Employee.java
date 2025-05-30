package lab4.prog7;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {
    private Account savingsAcct;
    private Account checkingAcct;
    private Account retirementAcct;
    private String name;
    private LocalDate hireDate;

    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
        this.name = name;
        this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
    }

    public void createNewChecking(double startAmount) {
        checkingAcct = new Account(AccountType.CHECKING, startAmount);
    }

    public void createNewSavings(double startAmount) {
        savingsAcct = new Account(AccountType.SAVINGS, startAmount);
    }

    public void createNewRetirement(double startAmount) {
        retirementAcct = new Account(AccountType.RETIREMENT, startAmount);
    }

    public void deposit(AccountType acctType, double amt) {
        switch (acctType) {
            case CHECKING: checkingAcct.makeDeposit(amt); break;
            case SAVINGS: savingsAcct.makeDeposit(amt); break;
            case RETIREMENT: retirementAcct.makeDeposit(amt); break;
        }
    }

    public boolean withdraw(AccountType acctType, double amt) {
        switch (acctType) {
            case CHECKING: return checkingAcct.makeWithdrawal(amt);
            case SAVINGS: return savingsAcct.makeWithdrawal(amt);
            case RETIREMENT: return retirementAcct.makeWithdrawal(amt);
            default: return false;
        }
    }

    public Account getLargestAccount() {
        Account largestAccount = checkingAcct;
        if (savingsAcct != null && savingsAcct.compareTo(largestAccount) > 0) {
            largestAccount = savingsAcct;
        }
        if (retirementAcct != null && retirementAcct.compareTo(largestAccount) > 0) {
            largestAccount = retirementAcct;
        }
        return largestAccount;
    }

    @Override
    public int compareTo(Employee compareEmp) {
        return this.getLargestAccount().compareTo(compareEmp.getLargestAccount());
    }

    public String getFormattedAcctInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ACCOUNT INFO FOR ").append(name).append(":\n\n");
        if (checkingAcct != null) sb.append(checkingAcct.toString());
        if (savingsAcct != null) sb.append(savingsAcct.toString());
        if (retirementAcct != null) sb.append(retirementAcct.toString());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return name + " : " + getLargestAccount().getBalance();
    }
}
