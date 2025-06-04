package prog4;

public final class Exponential {
    public double power(double x, double n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Exponential e = new Exponential();
        System.out.println(e.power(3.5, 4));
    }
}