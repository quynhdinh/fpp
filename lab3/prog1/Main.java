package prog1;

import employeeinfo.AccountType;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Leonardo", "Leo", 100.0, 2025, 12, 29);
        Account account = new Account(employee, AccountType.CHECKING, 300);
        Account account2 = new Account(employee, AccountType.RETIREMENT, 300);
        Account account3 = new Account(employee, AccountType.SAVINGS, 300);
        System.out.println(account);
        System.out.println(account2);
        System.out.println(account3);
    }
}
