package prog5.closedcurve.good;

public final class Rectangle extends ClosedCurve implements Polygon {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return width * height;
    }

    @Override
    public double[] getArrayOfSides() {
        return new double[]{width, width, height, height};
    }
}
