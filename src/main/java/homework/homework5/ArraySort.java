package homework.homework5;

public class ArraySort {

    public static void main(String[] args) {

        int[] numbers = {43, 55, 5, -9, 0, 12, 5, 65};
        int buffer;
        boolean arraySorted = false;
        while (!arraySorted) {
            arraySorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    buffer = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = buffer;
                    arraySorted = false;
                }
            }
        }

        for (int x : numbers) {
            System.out.print(x + " ");
        }

        System.out.println();
        arraySorted = false;


        while (!arraySorted) {
            arraySorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] < numbers[i + 1]) {
                    buffer = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = buffer;
                    arraySorted = false;
                }
            }
        }

        for (int x : numbers) {
            System.out.print(x + " ");
        }

    }
}
