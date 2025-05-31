package prog4.closedcurve.good;

public final class Rectangle extends ClosedCurve implements Polygon {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double computeArea() {
        return width * height;
    }

    @Override
    public int getNumberOfSides() {
        return 4;
    }

    @Override
    public double computePerimeter() {
        return 2 * (width + height);
    }
}
