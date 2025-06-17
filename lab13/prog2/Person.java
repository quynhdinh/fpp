package lab13.prog2;

public record Person(String id, String firstName, String lastName, String ssn) {
    @Override
    public String toString() {
        return "[" + id + ": " + firstName + " " + lastName + " " + ssn + "]";
    }
}