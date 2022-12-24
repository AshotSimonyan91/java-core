package homework.homework3;

public class ArrayUtil2 {
    public static void main(String[] args) {
        int[] array = {-2, 5, 8, 23, 54, 754, 2466, 3, 97, 45};
        int a = 0;
        int b = 0;
        int x = 0;
        System.out.print("1:Զույգ էլեմենտները: ");
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                a++;
                System.out.print(array[i] + " ");
            }
        }

        System.out.print("\n2:Կենտ էլեմենտները: ");
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                b++;
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("3:Կենտերի և զույգերի քանակը: " + a + "   " + b);

        for (int i = 0; i < array.length; i++) {
            x += array[i];
        }
        System.out.println("4:Միջին թվաբանականը:  " + (double) x / array.length);

        System.out.println("5:Մասիվի էլեմենտների գումարը: " + x);

        System.out.println("6:Մասիվի արաջին և վերջին էլեմենտները: " + array[0] + ", " + array[array.length - 1]);

        System.out.print("7:Մասիվի մեջտեղի էլեմենտը:  ");

        if (array.length % 2 == 0) {
            System.out.println(array[array.length / 2 - 1] + " "
                    + array[array.length / 2]
                    + "    քանի որ մասիվի անդամների քանակը զույգ է");
        } else {
            System.out.println(array[array.length / 2]);
        }
    }
}
