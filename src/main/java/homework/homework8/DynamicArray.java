package homework.homework8;

public class DynamicArray {
    private int[] array;
    private int arrayIndex;

    DynamicArray() {
        arrayIndex = 0;
        array = new int[10];
    }

    DynamicArray(int size) {
        arrayIndex = 0;
        array = new int[size];
    }

    private void extend() {
        int[] arrayOne = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            arrayOne[i] = array[i];
        }
        array = arrayOne;
    }

    public void add(int item) {
        if (arrayIndex >= array.length) {
            extend();
        }
        array[arrayIndex] = item;
        arrayIndex++;
    }

    public void print() {
        for (int i = 0; i < arrayIndex; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int get(int index) {
        if (index >= array.length || index < 0) {
            System.out.println("Incorrect index");
            return -1;
        }
        if (index >= arrayIndex) {
            System.out.println("Did not add elements");
        }
        return array[index];
    }

    public void delete(int index) {
        if (arrayIndex != 0) {
            if (index >= 0 && index <= arrayIndex) {
                for (int i = index; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                arrayIndex--;
                return;
            }
            System.out.println("Incorrect index");
            System.out.println("Enter index from 0 until " + (arrayIndex - 1));
        }
    }

    public void set(int index, int value) {
        if (index < 0 || index > arrayIndex) {
            System.out.println("Incorrect index");
            return;
        }
        array[index] = value;
    }

    public void add(int index, int value) {
        if (index >= 0 || index < arrayIndex) {
            if (arrayIndex == array.length) extend();
            for (int i = arrayIndex; i >= index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            arrayIndex++;
            return;
        }
        System.out.println("Incorrect index");
    }

    public boolean exists(int value) {
        boolean val = false;
        for (int i = 0; i < arrayIndex; i++) {
            if (array[i] == value) {
                val = true;
                break;
            }
        }
        return val;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < arrayIndex; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        System.out.println("Didn't have value");
        return -1;
    }
}
