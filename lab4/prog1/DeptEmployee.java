package prog1;

import java.time.LocalDate;

public abstract class DeptEmployee {
    private String name;
    protected int salary;
    private LocalDate hireDate;

    protected DeptEmployee(String name, int salary, LocalDate hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public int computeSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return getName();
    }
}
