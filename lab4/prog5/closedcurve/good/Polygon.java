package prog5.closedcurve.good;

public interface Polygon {
    public double[] getArrayOfSides();

    static double sum(double[] arr) {
        double res = 0;
        for (double d : arr) {
            res += d;
        }
        return res;
    }

    default double computePerimeter() {
        return Polygon.sum(getArrayOfSides());
    }
}
