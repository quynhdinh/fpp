package lab5.prog1;

public class Main {
    public static void main(String[] args) {

        // testing to prove singleton
        MySingleton s1 = MySingleton.getSingletonInstance();
        MySingleton s2 = MySingleton.getSingletonInstance();

        // s1 == s2 should give true
        System.out.println(s1 == s2);
    }
}