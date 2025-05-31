package lab4.prog6.case3;

import java.util.GregorianCalendar;

public class PersonWithJob {
    private Person person;
    private double salary;

    PersonWithJob(String name, GregorianCalendar dob, double salary) {
        this.person = new Person(name, dob);
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        PersonWithJob personWithJob = (PersonWithJob) obj;
        return person.equals(personWithJob.person) && Math.abs(this.salary - personWithJob.salary) < 0.0001;
    }
}
