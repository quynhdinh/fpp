package prog2.closedcurve.good;

public final class Rectangle extends ClosedCurve {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double computeArea() {
        return width * height;
    }
}
