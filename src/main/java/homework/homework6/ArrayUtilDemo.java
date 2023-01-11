package homework.homework6;

public class ArrayUtilDemo {

    public static void main(String[] args) {
        int[] array = {2, 5, 8, 10, 88, 22, 11, 66, 12, 30, 6, 4, 3};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.maxOfArray(array);
        arrayUtil.minOfArray(array);
        arrayUtil.evenOfArray(array);
        arrayUtil.oddOfArray(array);
        arrayUtil.evenCounter(array);
        arrayUtil.oddCounter(array);
        arrayUtil.averageOfArray(array);
        arrayUtil.sumMemberOfArray(array);
        arrayUtil.firstAndLastMembers(array);
        arrayUtil.middleMemberOfArray(array);
    }
}
