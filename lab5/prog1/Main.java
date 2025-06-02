package lab5.prog1;

public class Main {
    public static void main(String[] args) {

        // testing to prove singleton
        MysSngleton s1 = MysSngleton.getSingletonInstance();
        MysSngleton s2 = MysSngleton.getSingletonInstance();

        // s1 == s2 should give true
        System.out.println(s1 == s2);
    }
}