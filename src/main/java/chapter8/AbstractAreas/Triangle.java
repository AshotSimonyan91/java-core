package chapter8.AbstractAreas;

public class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    double area() {
        System.out.println("area of triangle");
        return dim1 * dim2 / 2;
    }
}
