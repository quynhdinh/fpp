package lab12.prog2;

public class OverdrawnAccountException extends Exception {
    public OverdrawnAccountException(String message) {
        super(message);
    }
}
