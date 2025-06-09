package lab8.prog3.employeesort;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary() - e2.getSalary();
    }
}
