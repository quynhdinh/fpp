package lab4.prog6.case3;

import java.util.GregorianCalendar;
import java.util.Objects;

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
        if (obj == null || this.getClass() != obj.getClass()) return false;
        PersonWithJob other = (PersonWithJob) obj;
        return person.equals(other.person) && salary == other.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, salary);
    }
}
