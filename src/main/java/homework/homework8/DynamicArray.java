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
        if (index >= 0 && index < arrayIndex) {
            if (arrayIndex == 0) {
                System.out.println("Array is empty");
            } else {
                int j = 0;
                int[] arrayTwo = new int[array.length - 1];
                for (int i = 0; i < array.length; i++) {
                    if (index != i) {
                        arrayTwo[j] = array[i];
                        j++;
                    }
                }
                array = arrayTwo;
                arrayIndex--;
            }
        } else {
            System.out.println("Incorrect index");
            System.out.println("Enter index from 0 until " + (array.length - 1));
        }

    }

    public void set(int index, int value) {
        if (index < 0 && index > arrayIndex) {
            System.out.println("Incorrect index");
        } else {
            array[index] = value;
        }
    }

    public void add(int index, int value) {
        if (index < 0 && index > arrayIndex) {
            System.out.println("Incorrect index");
        } else {
            int buf = 0;
            int temp = array[index];
            array[index] = value;
            for (int i = index; i < arrayIndex; i++) {
                if (arrayIndex == array.length) extend();
                buf = array[i + 1];
                array[i + 1] = temp;
                temp = buf;
            }
            arrayIndex++;
        }
    }

    public boolean exists(int value) {
        boolean val = false;
        for (int i = 0; i < arrayIndex; i++) {
            if (array[i] == value) {
                val = true;
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
