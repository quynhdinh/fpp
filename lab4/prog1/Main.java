package prog1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DeptEmployee p1 = new Professor("Thao", 100, new Date(2024, 12, 1), 10);
        DeptEmployee p2 = new Professor("Ola", 200, new Date(2023, 11, 2), 10);
        DeptEmployee p3 = new Professor("Helena", 100, new Date(2022, 10, 3), 10);
        Secretary s1 = new Secretary("Jensen", 200, new Date(2021, 9, 4), 200);
        Secretary s2 = new Secretary("Steve", 300, new Date(2020, 8, 5), 200    );
        DeptEmployee[] department = new DeptEmployee[]{p1, p2, p3, s1, s2};
        int total = 0;
        for (DeptEmployee employee : department) {
            total += employee.computeSalary();
        }
        System.out.println(total);
    }
}