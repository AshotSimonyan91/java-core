package chapter14;

public class NonGen {
    Object ob;

    public NonGen(Object ob) {
        this.ob = ob;
    }

    public Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}
