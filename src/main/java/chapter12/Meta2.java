package chapter12;

import java.lang.reflect.Method;

public class Meta2 {
    @MyAnno(str = "example", val = 100)
    public static void myMeth(String str, int i) {
        Meta2 ob = new Meta2();
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth", String.class,int.class);
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
