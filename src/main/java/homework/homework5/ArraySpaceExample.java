package homework.homework5;

public class ArraySpaceExample {

    public static void main(String[] args) {

        char[] spaceArray = {' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};
        char freespace = ' ';
        int firstindex = 0;
        int lastindex = spaceArray.length - 1;

        for (char val : spaceArray) {
            if (val != freespace) {
                break;
            }
            firstindex++;

        }

        for (int i = spaceArray.length - 1; i > 0; i--) {
            if (spaceArray[i] != freespace) {
                break;
            }
            lastindex--;
        }

        char[] newSpaceArray = new char[lastindex - firstindex + 1];

        for (int i = 0; i < newSpaceArray.length; i++) {
            newSpaceArray[i] = spaceArray[firstindex];
            firstindex++;
        }

        for (char val : newSpaceArray) {
            System.out.print(val);
        }

    }
}
