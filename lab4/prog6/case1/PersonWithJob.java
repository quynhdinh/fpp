package lab4.prog6.case1;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
    private double salary;

    public PersonWithJob(String name, GregorianCalendar dob, double salary) {
        super(name, dob);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

}
