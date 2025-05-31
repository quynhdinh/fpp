package prog3;

import employeeinfo.Employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("A. See a report of all accounts.");
        System.out.println("B. Make a deposit.");
        System.out.println("C. Make a withdrawal.");
        System.out.println("Make a selection(A / B / C) ");

        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee("Nur", 2025, 4, 25);
        Employee employee2 = new Employee("Ola", 2024, 5, 24);
        Employee employee3 = new Employee("Helena", 2023, 6, 23);
        Employee employee4 = new Employee("Citiz", 2022, 8, 22);
        employee.createNewChecking(100);
        employee.createNewRetirement(100);
        employee.createNewSavings(100);
        Employee[] employees = new Employee[]{employee, employee2, employee3, employee4};

        String answer = sc.next().toUpperCase();
        if (answer.equals("A")) {
            System.out.println(employee.getFormattedAcctInfo());
        } else if (answer.equals("B") || answer.equals("C")) {
            MyStringList l = new MyStringList();
            for (Employee employee1 : employees) {
                String name = employee1.getName();
                l.add(name);
            }
            for (int i = 0; i < l.size(); i++)
                System.out.println(i + ". " + l.get(i));
            System.out.println("Select an employee: (type a number)");
            int i = Integer.parseInt(sc.next());
            MyStringList accs = employees[i].getNamesOfAccounts();
            for (int j = 0; j < accs.size(); j++)
                System.out.println(j + ". " + accs.get(j));
            System.out.println("Select an account: (type a number) ");
            int acc = Integer.parseInt(sc.next());
            System.out.println(answer.equals("B") ? "Deposit amount: " : "Withdraw amount: ");
            int amount = Integer.parseInt(sc.next());
            String msg = "";
            if (answer.equals("B")) {
                employees[i].deposit(acc, amount);
                msg = String.format("$%s has been deposited in the %s account of %s", amount, accs.get(acc), employees[i].getName());
            } else {
                if (employees[i].withdraw(acc, amount)) {
                    msg = String.format("Withdrew successfully %s out of ");
                } else {
                    msg = String.format("Withdrew successfully %s out of %s account of %s", amount, accs.get(acc), employees[i].getName());
                }
            }
            System.out.println(msg);
        }
        sc.close();
    }
}
