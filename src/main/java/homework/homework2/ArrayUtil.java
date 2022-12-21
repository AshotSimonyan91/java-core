package homework.homework2;

public class ArrayUtil {

    public static void main(String[] args) {
        int[] array = {-2, 5, 8, 23, 54, 754, 2466, 3, 97, 45};
        int maxValue = array[0];
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        System.out.println("max value: " + maxValue);

        System.out.println("min value: " + minValue);
    }
}
