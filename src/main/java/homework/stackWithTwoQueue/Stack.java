package homework.stackWithTwoQueue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Stack<T> {

    private Queue<T> mainStack;
    private Queue<T> tempStack;

    public Stack() {
        mainStack = new LinkedList<>();
        tempStack = new LinkedList<>();
    }

    //Implement the Stack methods using only two Queue objects
    public T push(T element) {
        mainStack.add(element);
        return element;
    }

    public T pop() {
        if (mainStack.isEmpty()) {
            return null;
        }

        while (mainStack.size() > 1) {
            tempStack.add(mainStack.remove());
        }

        T item = mainStack.remove();
        Queue<T> temp = mainStack;
        mainStack = tempStack;
        tempStack = temp;

        return item;
    }

    public T peek() {
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stack<?> stack = (Stack<?>) o;

        if (!Objects.equals(mainStack, stack.mainStack)) return false;
        return Objects.equals(tempStack, stack.tempStack);
    }

    @Override
    public int hashCode() {
        int result = mainStack != null ? mainStack.hashCode() : 0;
        result = 31 * result + (tempStack != null ? tempStack.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return mainStack.toString();
    }
}
