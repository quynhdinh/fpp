package lab4.prog6.case3;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Person {
    private String name;
    private GregorianCalendar dateOfBirth;

    Person(String name, GregorianCalendar dob) {
        this.name = name;
        this.dateOfBirth = dob;
    }

    public String getName() {
        return name;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return name.equals(other.name) && dateOfBirth.equals(other.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth);
    }
}
