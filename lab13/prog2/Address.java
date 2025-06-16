package lab13.prog2;

public record Address(long id, String street, String city, String state, String zip) {
    @Override
    public String toString() {
        return String.format("[%s %s %s %s, %s]", id, street, city, state, zip);
    }
}