package prog5.closedcurve.good;

public class Test {

    public static void main(String[] args) {

        ClosedCurve[] objects = {
                new Rectangle(3, 4),
                new Triangle(4, 5, 6),
                new Square(3),
        };
        //compute perimeter
        for (ClosedCurve cc : objects) {
            System.out.println("For this " + cc.getClass().getSimpleName());
            Polygon p = (Polygon) cc;
            System.out.println("\tPerimeter = " + p.computePerimeter());
        }

    }

}