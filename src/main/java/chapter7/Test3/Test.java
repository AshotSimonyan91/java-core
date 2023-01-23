package chapter7.Test3;

public class Test {

    int a;

    public Test(int a) {
        this.a = a;
    }

    Test incrByTen() {
        Test temp = new Test(a + 10);
        return temp;
    }
}
