package lab11.prog1;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    private String firstName;
    private String lastName;
    private Map<String, Double> salaryRecord;

    public Employee() {
        salaryRecord = new HashMap<>();
    }

    public void addEntry(String date, double salary) {
        salaryRecord.put(date, salary);
    }

    public void printPaymentAmount(String date) {
        if (salaryRecord.containsKey(date)) {
            System.out.printf("%s %s was paid %s on %s\n", firstName, lastName, salaryRecord.get(date), date);
        } else {
            System.out.printf("%s %s did not receive a paycheck on %s\n", firstName, lastName, date);
        }
    }

    public void printAveragePaycheck() {
        double sum = 0;
        if (salaryRecord.isEmpty()) {
            System.out.println("No paycheck found");
            return;
        }
        for (double amount : salaryRecord.values()) {
            sum += amount;
        }
        double result = sum / salaryRecord.size();
        System.out.printf("Average paycheck for %s %s was %s\n", firstName, lastName, result);
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