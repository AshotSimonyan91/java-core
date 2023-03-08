package chapter14;

public class Gen2<T,V> extends Gen<T> {
    V ob2;
    public Gen2(T ob,V ob2) {
        super(ob);
        this.ob2 = ob2;
    }

    public V getOb2() {
        return ob2;
    }
}
