package lab12.prog1.closedcurve.good;

public final class Circle extends ClosedCurve {
	private final double radius;

	public Circle(double radius) throws IllegalClosedCurveException {
		if (radius <= 0) {
			throw new IllegalClosedCurveException("Radius must be positive");
		}
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		return Math.PI * radius * radius;
	}
}