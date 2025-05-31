package lab4.prog6.case1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Bob", new GregorianCalendar(1990, Calendar.JUNE, 8));
        PersonWithJob personWithJob = new PersonWithJob("Bob", new GregorianCalendar(1990, Calendar.JUNE, 8), 200.0);
        System.out.println(personWithJob.equals(personWithJob));
        System.out.println(person.equals(person));
        System.out.println(person.equals(personWithJob));
        System.out.println(personWithJob.equals(person));
    }

}
