package homework.homework9;

public class Stack {
    private char[] stck;
    private int tos;

    Stack() {
        stck = new char[10];
        tos = -1;
    }

    Stack(int size) {
        stck = new char[size];
        tos = -1;
    }

    private void extend() {
        char[] array = new char[stck.length + 10];
        for (int i = 0; i < stck.length; i++) {
            array[i] = stck[i];
        }
        stck = array;
    }

    void push(char item) {
        if (tos >= stck.length - 1) {
            extend();
        }
        stck[++tos] = item;
    }

    char pop() {
        if (tos < 0) {
            System.out.println("Stack is empty");
            return 0;
        }
        return stck[tos--];
    }
}
