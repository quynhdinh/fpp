package lab13.prog2;

public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String ssn;

    public Person(String id, String firstName, String lastName, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "[" + id + ": " + firstName + " " + lastName + " " + ssn + "]";
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }
}