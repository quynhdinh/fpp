package employeeinfo;

import prog3.*;

import java.time.LocalDate;

public class Employee {
    private AccountList accounts;
    private String name;
    private LocalDate hireDate;

    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
        this.name = name;
        this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
        accounts = new AccountList();
    }

    public void deposit(int accountIndex, double amt) {
        if (accountIndex < 0 || accountIndex > 2) return;
        Account targetAccount = null;
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (accountIndex == 0 && account.getAccountType().name().equals("CHECKING")) {
                targetAccount = account;
                break;
            } else if (accountIndex == 1 && account.getAccountType().name().equals("SAVINGS")) {
                targetAccount = account;
            } else if (accountIndex == 2 && account.getAccountType().name().equals("RETIREMENT")) {
                targetAccount = account;
            }
        }
        assert targetAccount != null;
        targetAccount.makeDeposit(amt);
    }

    public boolean withdraw(int accountIndex, double amt) {
        if (accountIndex < 0 || accountIndex > 2) return false;
        Account targetAccount = null;
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (accountIndex == 0 && account.getAccountType().name().equals("checking")) {
                targetAccount = account;
                break;
            } else if (accountIndex == 1 && account.getAccountType().name().equals("savings")) {
                targetAccount = account;
            } else if (accountIndex == 2 && account.getAccountType().name().equals("retirement")) {
                targetAccount = account;
            }
        }
        assert targetAccount != null;
        return targetAccount.makeWithdrawal(amt);
    }

    public String getFormattedAcctInfo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++) {
            sb.append(accounts.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public void createNewSavings(double startBalance) {
        Account acct = new SavingsAccount(startBalance);
        accounts.add(acct);
    }

    public void createNewRetirement(double startBalance) {
        Account acct = new RetirementAccount(startBalance);
        accounts.add(acct);
    }

    public void createNewChecking(double startBalance) {
        Account acct = new CheckingAccount(startBalance);
        accounts.add(acct);
    }

    public MyStringList getNamesOfAccounts() {
        MyStringList l = new MyStringList();
        for (int i = 0; i < accounts.size(); i++)
            l.add(accounts.get(i).getAccountType().type);
        return l;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
}