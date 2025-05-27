class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String str, String cit, String st, String z) {
        street = str;
        city = cit;
        state = st;
        zip = z;
    }

    public String toString() {
        return street + ", " + city + ", " + state + " " + zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}

public class Customer {
    private String firstName, lastName, socSecurityNum;
    private Address billingAddress, shippingAddress;

    public Customer(String fn, String ln, String ssn, Address ba, Address sa) {
        this.firstName = fn;
        this.lastName = ln;
        this.socSecurityNum = ssn;
        this.billingAddress = ba;
        this.shippingAddress = sa;
    }

    public String getFirstName() {
        return this.getFirstName();
    }

    public String getLastName() {
        return this.getLastName();
    }

    public String getSocSecurityNum() {
        return this.socSecurityNum;
    }

    public Address getBillingAddress() {
        return this.billingAddress;
    }

    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    public void setSOCSecurityNumber(String ssn) {
        this.socSecurityNum = ssn;
    }

    public void setBillingAddress(Address ba) {
        this.billingAddress = ba;
    }

    public void settingShippingAddress(Address sa) {
        this.shippingAddress = sa;
    }

    @Override
    public String toString() {
        return "[" + firstName + ", " + lastName + ", ssn: " + socSecurityNum + "]";

    }

    public static void main(String[] args) {
        Address chicago = new Address("John", "Chicago", "Illinois", "60007");
        Address miu = new Address("Thao", "Fairfield", "Iowa", "52557");
        Address psu = new Address("Amigo", "Portland", "Oregon", "97201");
        Address usc = new Address("Rod", "Los Angeles", "California", "90007");
        Customer c1 = new Customer("Leonardo", "Encalada", "6789", chicago, miu);
        Customer c2 = new Customer("Azeem", "Mizra", "6789", usc, psu);
        Customer c3 = new Customer("Zeeshan", "Sanwar", "1234", chicago, miu);
        Customer[] customers = { c1, c2, c3 };
        for (Customer customer : customers) {
            if (customer.getBillingAddress().getCity().equals("Chicago")) {
                System.out.println(customer);
            }
        }
    }
}
