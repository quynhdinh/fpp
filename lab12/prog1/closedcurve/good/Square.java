package lab12.prog1.closedcurve.good;

public final class Square extends ClosedCurve {
    private final double side;

    public Square(double side) throws IllegalClosedCurveException {
        if (side <= 0) {
            throw new IllegalClosedCurveException("Side must be positive");
        }
        this.side = side;
    }

    @Override
    public double computeArea() {
        return side * side;
    }
}
