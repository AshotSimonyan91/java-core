package chapter10;

public class FinallyDemo {
    static void procA() {
        try {
            System.out.println("in method procA()");
            throw new RuntimeException("demonstration");
        } finally {
            System.out.println("finally from procA()");
        }
    }

    static void procB() {
        try {
            System.out.println("in method procB()");
            return;
        } finally {
            System.out.println("finally from procB()");
        }
    }

    static void procC() {
        try {
            System.out.println("in method procC()");
        } finally {
            System.out.println("finally from procC()");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println(e);
        }

        procB();
        procC();
    }
}
