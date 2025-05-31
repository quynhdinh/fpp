package lab4.prog6.case1;

import java.util.GregorianCalendar;

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
        if (obj == null || !(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return name.equals(other.name) && dateOfBirth.equals(other.dateOfBirth);
    }

}

