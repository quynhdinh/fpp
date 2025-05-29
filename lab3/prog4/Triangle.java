package prog4;

public final class Triangle {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getWidth() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "Triangle(" + base + ", " + height + ")";
    }

    public double computeArea() {
        return 0.5 * base * height;
    }
}
