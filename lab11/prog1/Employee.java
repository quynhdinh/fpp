package lab11.prog1;

import java.util.HashMap;

public class Employee {
    private String firstName;
    private String lastName;
    private HashMap<String, Double> salaryRecord;

    public Employee() {
        salaryRecord = new HashMap<>();
    }

    public void addEntry(String date, double salary) {
        // implement
        salaryRecord.put(date, salary);
    }

    public void printPaymentAmount(String date) {
        // implement
        Double payment = salaryRecord.get(date);
        if (payment != null) {
            System.out.println(firstName + " " + lastName + "was paid " + payment + " on " + date);
        } else {
            System.out.println(firstName + " " + lastName + "did not receive on " + date);
        }
    }

    public void printAveragePaycheck() {
        // implement
        double sum = 0;
        if (salaryRecord.isEmpty()) {
            System.out.println("No paycheck found");
        }
        for (double amount : salaryRecord.values()) {
            sum += amount;
        }

        double result = sum / salaryRecord.size();
        System.out.println("Average paycheck for " + firstName + " " + lastName + "was " + result);
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setFirstName("Jim");
        e.setLastName("Jones");
        for (int i = 1; i <= 12; ++i) {
            e.addEntry(i + "/15/2011", 3070 + 5 * i);
        }
        e.printPaymentAmount("3/15/2011");
        e.printPaymentAmount("5/15/2010");
        e.printAveragePaycheck();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}