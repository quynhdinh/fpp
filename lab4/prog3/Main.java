package prog3;

import employeeinfo.Employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = getEmployees();
        while (true) {
            System.out.println("A. See a report of all accounts.");
            System.out.println("B. Make a deposit.");
            System.out.println("C. Make a withdrawal.");
            System.out.println("D. Quit.");
            System.out.print("Make a selection(A / B / C / D) ");

            String answer = sc.next().toUpperCase();
            if (answer.equals("A")) {
                for (Employee employee : employees)
                    System.out.println(employee.getFormattedAcctInfo());
            } else if (answer.equals("B") || answer.equals("C")) {
                for (int i = 0; i < employees.length; i++)
                    System.out.println(i + ". " + employees[i].getName());
                System.out.print("Select an employee: (type a number) ");
                int employeeIndex = Integer.parseInt(sc.next());
                MyStringList accounts = employees[employeeIndex].getNamesOfAccounts();
                for (int j = 0; j < accounts.size(); j++)
                    System.out.println(j + ". " + accounts.get(j));
                System.out.print("Select an account: (type a number) ");
                int acc = Integer.parseInt(sc.next());
                System.out.print(answer.equals("B") ? "Deposit amount: " : "Withdraw amount: ");
                int amount = Integer.parseInt(sc.next());
                String msg;
                if (answer.equals("B")) {
                    employees[employeeIndex].deposit(acc, amount);
                    msg = String.format("$%s has been deposited in the %s account of %s", amount, accounts.get(acc), employees[employeeIndex].getName());
                } else {
                    if (employees[employeeIndex].withdraw(acc, amount))
                        msg = String.format("Withdrew successfully %s out of %s account of %s", amount, accounts.get(acc), employees[employeeIndex].getName());
                    else
                        msg = String.format("Withdrew unsuccessfully %s out of %s account of %s", amount, accounts.get(acc), employees[employeeIndex].getName());
                }
                System.out.println(msg);
            } else {
                break;
            }
        }
        sc.close();
    }

    private static Employee[] getEmployees() {
        Employee employee1 = new Employee("Nur", 2025, 4, 25);
        Employee employee2 = new Employee("Ola", 2024, 5, 24);
        Employee[] employees = new Employee[]{employee1, employee2};
        for (Employee employee : employees) {
            employee.createNewChecking(100);
            employee.createNewRetirement(100);
            employee.createNewSavings(100);
        }
        return employees;
    }
}
