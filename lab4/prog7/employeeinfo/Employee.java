package prog7.employeeinfo;

import prog7.MyStringList;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee> {
    private AccountList accounts;
    private String name;
    private Date hireDate;

    public Employee(String name, int year, int month, int day) {
        this.name = name;
        GregorianCalendar cal = new GregorianCalendar(year, month, day);
        hireDate = cal.getTime();
        accounts = new AccountList();
    }

    /**
     * returns a list of account types in the order in which
     * accounts are stored in the AccountList
     */
    public MyStringList getNamesOfAccounts() {
        MyStringList names = new MyStringList();
        for (int i = 0; i < accounts.size(); ++i) {
            names.add(accounts.get(i).getAcctType().toString().toLowerCase());
        }
        return names;

    }

    public void createNewSavings(double startBalance) {
        accounts.add(new SavingsAccount(this, startBalance));
    }

    public void createNewChecking(double startBalance) {
        accounts.add(new CheckingAccount(this, startBalance));
    }

    public void createNewRetirement(double startBalance) {
        accounts.add(new RetirementAccount(this, startBalance));

    }

    public void deposit(int acctIndex, double amt) {
        Account selected = accounts.get(acctIndex);
        selected.makeDeposit(amt);
    }

    public boolean withdraw(int acctIndex, double amt) {
        Account selected = accounts.get(acctIndex);
        return selected.makeWithdrawal(amt);
    }


    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return (Date) hireDate.clone();
    }

    private String n = System.getProperty("line.separator");

    @Override
    public String toString() {
        return name + " : " + accounts.getLargest().getBalance();
    }

    @Override
    public int compareTo(Employee o) {
        Account myLargest = accounts.getLargest();
        Account hisLargest = o.accounts.getLargest();
        return myLargest.compareTo(hisLargest);
    }
}
