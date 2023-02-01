package chapter8.OverrideDemo;

import java.lang.Override;

public class B extends A{
    int k;

    public B(int a, int b, int c) {
        super(a, b);
        this.k = c;
    }

    @Override
     void show() {
        super.show();
        System.out.println(k);
    }
}
