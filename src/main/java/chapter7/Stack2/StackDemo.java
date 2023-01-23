package chapter7.Stack2;

public class StackDemo {
    public static void main(String[] args) {
        Stack mystack1 = new Stack(5);
        Stack mystack2 = new Stack(8);

        for (int i = 0; i < 5; i++) {
            mystack1.push(i);
        }
        for (int i = 0; i < 8; i++) {
            mystack2.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(mystack1.pop());
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(mystack2.pop());
        }
    }
}
