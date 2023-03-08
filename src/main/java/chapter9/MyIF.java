package chapter9;

public interface MyIF {
    int getNumber();
    default String getString() {
        return "default string type";
    }

    static int getDefaultNumber() {
        return 0;
    }
}
