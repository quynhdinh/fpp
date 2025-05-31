package prog1;

import java.util.Date;

public class DeptEmployee {
    private String name;
    protected int salary;
    private Date hireDate;

    protected DeptEmployee(String name, int salary, Date hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = new Date(hireDate.getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return new Date(hireDate.getTime());
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int computeSalary(){
        return salary;
    }
}
