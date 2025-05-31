package prog1;

import java.time.LocalDate;

public class Professor extends DeptEmployee {

    private int numberOfPublications;

    public Professor(String name, int salary, LocalDate date, int numberOfPublications) {
        super(name, salary, date);
        this.numberOfPublications = numberOfPublications;
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }

}