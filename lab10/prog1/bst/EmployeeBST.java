package bst;

import java.util.Comparator;

import employeebst.Employee;

public class EmployeeBST {
    private EmployeeNode root;
    private Comparator<Employee> comparator;

    private class EmployeeNode {
        EmployeeNode(Employee theElement) {
            this(theElement, null, null);
        }

        EmployeeNode(Employee element, EmployeeNode left, EmployeeNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        private Employee element;
        private EmployeeNode left;
        private EmployeeNode right;
    }

    public EmployeeBST(Comparator<Employee> nameComp) {
        this.comparator = nameComp;
    }

    public void insert(Employee x) {
        if (root == null) {
            root = new EmployeeNode(x);
        } else {
            EmployeeNode n = root;
            boolean inserted = false;
            while (!inserted) {
                int compareResult = comparator.compare(x, n.element);
                if (compareResult < 0) {
                    // space found on the left
                    if (n.left == null) {
                        n.left = new EmployeeNode(x);
                        inserted = true;
                    } else n = n.left;
                } else if (compareResult >= 0) {
                    // space found on the right
                    if (n.right == null) {
                        n.right = new EmployeeNode(x);
                        inserted = true;
                    } else n = n.right;
                }
            }
        }
    }

    public void printTree() {
        if (root == null)
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private void printTree(EmployeeNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

}