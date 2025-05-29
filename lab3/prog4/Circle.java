package prog4;

public final class Circle {
    private static final double PI = 3.14159265358979323846;
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle(" + radius + ")";
    }

    public double computeArea() {
        return PI * radius * radius;
    }
}
