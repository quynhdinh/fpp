package prog5.closedcurve.good;

public interface Polygon {
    double[] getArrayOfSides();

    static double perimeter(double[] arr) {
        double res = 0;
        for (double d : arr) {
            res += d;
        }
        return res;
    }

    default double computePerimeter() {
        return perimeter(getArrayOfSides());
    }
}
