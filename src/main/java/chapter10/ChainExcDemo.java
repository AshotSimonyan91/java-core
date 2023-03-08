package chapter10;

public class ChainExcDemo {
    static void demoproc () {
        NullPointerException e = new NullPointerException("top level");
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.println(e.getCause());
        }
    }
}
