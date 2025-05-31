package lab4.prog6.case2;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
    private double salary;

    PersonWithJob(String name, GregorianCalendar dob, double salary) {
        super(name, dob);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        PersonWithJob pWithJob = (PersonWithJob) obj;
        return getName().equals(pWithJob.getName())
            && getDateOfBirth().equals(pWithJob.getDateOfBirth())
            && salary == pWithJob.salary;
    }
}
