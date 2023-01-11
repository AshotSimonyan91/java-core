package homework.homework6;

public class ArrayUtil {

    void maxOfArray(int[] array) {
        int maxValue = array[0];

        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        System.out.println("max value of array: " + maxValue);
    }

    void minOfArray(int[] array) {
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        System.out.println("min value of array: " + minValue);
    }

    void evenOfArray(int[] array) {
        System.out.print("Even members of array:  ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    void oddOfArray(int[] array) {
        System.out.print("Odd members of array:  ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    void evenCounter(int[] array) {
        int evencounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evencounter++;
            }
        }
        System.out.println("Even count: " + evencounter);
    }

    void oddCounter(int[] array) {
        int oddcounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddcounter++;
            }
        }
        System.out.println("Odd count:" + oddcounter);
    }

    void averageOfArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println("Average of array:  " + (double) sum / array.length);
    }

    void sumMemberOfArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println("Sum members of array: " + sum);
    }

    void firstAndLastMembers(int[] array) {
        System.out.println("First and last members of array: " + array[0] + ", " + array[array.length - 1]);
    }

    void middleMemberOfArray(int[] array) {
        if (array.length % 2 == 0) {
            System.out.println("Middle member of array:  " + array[array.length / 2 - 1] + " "
                    + array[array.length / 2]
                    + "    because quantity of members is even");
        } else {
            System.out.println("Middle member of array:  " + array[array.length / 2]);
        }
    }
}




























