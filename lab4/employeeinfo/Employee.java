package employeeinfo;

import prog3.*;

import java.time.LocalDate;

public class Employee {
    private final AccountList accounts;
    private final String name;
    private final LocalDate hireDate;

    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
        this.name = name;
        this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
        accounts = new AccountList();
    }

    private Account getAccount(int accountIndex) {
        if (accountIndex < 0 || accountIndex > 2) return null;
        Account targetAccount = null;
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getAccountType().type == accountIndex) {
                targetAccount = account;
                break;
            }
        }
        return targetAccount;
    }

    public void deposit(int accountIndex, double amt) {
        Account targetAccount = getAccount(accountIndex);
        assert targetAccount != null;
        targetAccount.makeDeposit(amt);
    }

    public boolean withdraw(int accountIndex, double amt) {
        Account targetAccount = getAccount(accountIndex);
        assert targetAccount != null;
        return targetAccount.makeWithdrawal(amt);
    }

    public String getFormattedAcctInfo() {
        System.out.printf("%s has %s accounts\n", getName(), accounts.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++) {
            sb.append(accounts.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public void createNewSavings(double startBalance) {
        this.accounts.add(new SavingsAccount(this, startBalance));
    }

    public void createNewRetirement(double startBalance) {
        this.accounts.add(new RetirementAccount(this, startBalance));
    }

    public void createNewChecking(double startBalance) {
        this.accounts.add(new CheckingAccount(this, startBalance));
    }

    public MyStringList getNamesOfAccounts() {
        MyStringList l = new MyStringList();
        for (int i = 0; i < accounts.size(); i++)
            l.add(accounts.get(i).getAccountType().name().toUpperCase());
        return l;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
}