package employeebst;

import java.util.Comparator;

import bst.EmployeeBST;

public class EmployeeDriver {

	public static void main(String[] args) {
		new EmployeeDriver();
	}

	public EmployeeDriver() {
		Comparator<Employee> nameComp = new NameComparator();
		EmployeeBST bst = new EmployeeBST(nameComp);
		bst.insert(new Employee("George", 40000, 1996, 11, 5));
		bst.insert(new Employee("Dave", 50000, 2000, 1, 3));
		bst.insert(new Employee("Sally", 45000, 2001, 2, 7));
		bst.insert(new Employee("Richard", 80000, 1986, 3, 23));
		bst.printTree();
	}
}