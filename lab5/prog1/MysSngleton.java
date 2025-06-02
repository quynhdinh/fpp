package lab5.prog1;

public class MysSngleton {
    private static MysSngleton singletonInstance;

    // private constructor to restrict external creation of object
    private MysSngleton() {

    }

    // provide public access to singleton object
    public static MysSngleton getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MysSngleton();
        }
        return singletonInstance;
    }

}