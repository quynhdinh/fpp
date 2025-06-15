package lab12.prog1.closedcurve.good;

public class Rectangle extends ClosedCurve {
	private final double width;
	private final double length;

	public Rectangle(double width, double length) throws IllegalClosedCurveException {
		if (width <= 0 || length <= 0) {
			throw new IllegalClosedCurveException("Width and length must be positive");
		}
		this.length = length;
		this.width = width;
	}

	@Override
	double computeArea() {
		return width * length;
	}
}
