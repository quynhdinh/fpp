package lab5.prog1;

public class MySingleton {
    private static MySingleton singletonInstance;

    // private constructor to restrict external creation of object
    private MySingleton() {

    }

    // provide public access to singleton object
    public static MySingleton getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MySingleton();
        }
        return singletonInstance;
    }

}