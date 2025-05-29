package prog4;

public class Main {
    public static void main(String[] args) {
        Rectangle myRec = new Rectangle(4, 5);
        Triangle myTri = new Triangle(4, 5);
        Circle myCirc = new Circle(4);

        System.out.println("Area of a rectangle is " + myRec.computeArea());
        System.out.println("Area of a triangle is " + myTri.computeArea());
        System.out.printf("Area of a circle is %.2f", myCirc.computeArea());

    }
}
