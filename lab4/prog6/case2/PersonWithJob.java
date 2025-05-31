package lab4.prog6.case2;

import java.util.GregorianCalendar;

public final class PersonWithJob extends Person {
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
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        PersonWithJob personWithJob = (PersonWithJob) obj;
        return getName().equals(personWithJob.getName())
                && getDateOfBirth().equals(personWithJob.getDateOfBirth())
                && Math.abs(this.salary - personWithJob.salary) < 0.0001;
    }
}
