package chapter8.FindAreas;

public class Rectangle extends Figure{
    Rectangle(double a, double b) {
        super(a, b);
    }

    double area () {
        System.out.println("area of rectangle");
        return dim1 * dim2;
    }
}
