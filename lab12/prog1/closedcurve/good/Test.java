package lab12.prog1.closedcurve.good;

public class Test {

	public static void main(String[] args) {
		ClosedCurve[] objects = new ClosedCurve[7];
		String currentShape = "";

		try {
			currentShape = "Triangle";
			objects[0] = new Triangle(4, 5, 6);

			// currentShape = "Triangle";
			// objects[1] = new Triangle(1, 2, 10);

			currentShape = "Square";
			objects[2] = new Square(3);

			currentShape = "Square";
			objects[3] = new Square(-1);

			currentShape = "Circle";
			objects[4] = new Circle(3);

			currentShape = "Circle";
			objects[5] = new Circle(-3);

			currentShape = "Rectangle";
			objects[6] = new Rectangle(4, 7);

		} catch (IllegalClosedCurveException e) {
			System.out.println("An " + e.getClass().getSimpleName() +
					" was thrown in a " + currentShape + " instance.");
		}

		System.out.println("\n--- Area Calculations ---");
		for (ClosedCurve obj : objects) {
			if (obj != null) {
				System.out.println("Area of " + obj.getClass().getSimpleName() + " is " + obj.computeArea());
			}
		}
	}
}
