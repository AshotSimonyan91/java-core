package homework.homework8;

public class DynamicArrayDemo {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(5);

        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.print(dynamicArray.get(i) + " ");
//        }
//        System.out.println();
//        dynamicArray.print();

//        System.out.println(dynamicArray.get(12));
        dynamicArray.delete(33);

//        dynamicArray.add(3,9);
//        dynamicArray.delete(3);

//        System.out.println(dynamicArray.exists(33));
//        System.out.println(dynamicArray.getIndexByValue(6));


        dynamicArray.print();

    }

}
