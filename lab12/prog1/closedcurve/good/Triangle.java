package lab12.prog1.closedcurve.good;

import java.util.Arrays;

public final class Triangle extends ClosedCurve {
	private final double base;
	private final double height;
	private final double side1, side2, side3;
	private static final double DEFAULT_SIDE = 5.0;

	public Triangle(double base, double height) throws IllegalTriangleException {
		if (base <= 0 || height <= 0) {
			throw new IllegalTriangleException("Base and height must be positive");
		}
		if (height <= base) {
			this.base = base;
			this.height = height;
		} else {
			this.base = height;
			this.height = base;
		}
		side1 = this.height;
		side2 = this.base;
		side3 = Math.sqrt(base * base + height * height);
		assert (side1 <= side2 && side2 <= side3);
		assert (height <= base);
	}

	public Triangle(double s1, double s2, double s3) throws IllegalTriangleException {
		if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
			throw new IllegalTriangleException("Triangle sides must be positive");
		}

		double[] arr = { s1, s2, s3 };
		Arrays.sort(arr);
		double x = arr[0];
		double y = arr[1];
		double z = arr[2];

		if (x + y <= z) {
			throw new IllegalTriangleException("Illegal sides for a triangle: " + s1 + ", " + s2 + ", " + s3);
		}

		side1 = x;
		side2 = y;
		side3 = z;

		double u = (y * y - x * x + z * z) / (2 * z);
		double h = Math.sqrt(y * y - u * u);
		base = z;
		height = h;

		assert (side1 <= side2 && side2 <= side3);
		assert (height <= base);
	}

	public double computeArea() {
		return 0.5 * base * height;
	}
}
