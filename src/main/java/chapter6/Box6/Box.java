package chapter6.Box6;

public class Box {
    double width;
    double height;
    double depth;

    Box() {
        width = 10;
        height = 10;
        depth = 10;
    }

    double volume() {
        return width * height * depth;
    }
}
