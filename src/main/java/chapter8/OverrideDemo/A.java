package chapter8.OverrideDemo;

public class A {
    int i,j;
    A(int a, int b) {
        i = a;
        j = b;
    }

    void show() {
        System.out.println(i + " " + j);
    }
}
