package lab8.prog3.employeesort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeSort {

    public static void main(String[] args) {
        new EmployeeSort();

    }

    public EmployeeSort() {
        Employee[] empArray = {
                new Employee("George", 40000, 1999, 11, 5),
                new Employee("Dave", 50000, 2000, 1, 3),
                new Employee("Richard", 45000, 2001, 2, 7)
        };
        List<Employee> empList = Arrays.asList(empArray);

        System.out.println("SORTED BY NAME");
        NameComparator nameComp = new NameComparator();
        Collections.sort(empList, nameComp);
        System.out.println(empList);

        System.out.println("SORTED BY SALARY");
        SalaryComparator salaryComp = new SalaryComparator();
        Collections.sort(empList, salaryComp);
        System.out.println(empList);

        System.out.println("SORTED BY HIRE DATE");
        HireDateComparator hireDateComp = new HireDateComparator();
        Collections.sort(empList, hireDateComp);
        System.out.println(empList);

    }

}
