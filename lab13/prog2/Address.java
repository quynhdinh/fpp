package lab13.prog2;

public class Address {
    private final String id;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public Address(String id, String street, String city, String state, String zip) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return id + " " + street;
    }
}