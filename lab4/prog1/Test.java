package prog1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        DeptEmployee p1 = new Professor("Thao", 100, LocalDate.of(2024, 12, 1), 10);
        DeptEmployee p2 = new Professor("Ola", 200, LocalDate.of(2023, 11, 2), 10);
        DeptEmployee p3 = new Professor("Helena", 100, LocalDate.of(2022, 10, 3), 10);
        Secretary s1 = new Secretary("Jensen", 200, LocalDate.of(2021, 9, 4), 200);
        Secretary s2 = new Secretary("Steve", 300, LocalDate.of(2020, 8, 5), 200);
        DeptEmployee[] department = new DeptEmployee[]{p1, p2, p3, s1, s2};
        System.out.println("People are in the department are: " + Arrays.toString(department));
        System.out.print("Do you want to see sum of all salaries in the department ? (Y/N) ");
        Scanner sc = new Scanner(System.in);
        String ans = sc.next();
        if (ans.equalsIgnoreCase("Y")) {
            int totalMoney = 0;
            for (DeptEmployee employee : department)
                totalMoney += employee.computeSalary();
            System.out.println("The total is: $" + totalMoney);
        }
        sc.close();
    }
}