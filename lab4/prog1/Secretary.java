package prog1;

import java.time.LocalDate;

public class Secretary extends DeptEmployee {
    private int overtimeHours;

    public Secretary(String name, int salary, LocalDate date, int overtimeHours) {
        super(name, salary, date);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public int computeSalary() {
        return super.salary + overtimeHours * 12;
    }
}