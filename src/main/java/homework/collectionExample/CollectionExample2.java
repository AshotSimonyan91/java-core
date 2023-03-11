package homework.collectionExample;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CollectionExample2 {
    public static void printSortedInputedNames(Scanner scanner) {
        Set<String> name1 = new TreeSet<>();

        System.out.println("Pleas input 10 names");
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());
        name1.add(scanner.nextLine());

        System.out.println(name1.toString());
    }

    public static void printInputedNames(Scanner scanner) {
        Set<String> name = new HashSet<>();

        System.out.println("Pleas input 5 names");
        name.add(scanner.nextLine());
        name.add(scanner.nextLine());
        name.add(scanner.nextLine());
        name.add(scanner.nextLine());
        name.add(scanner.nextLine());

        System.out.println(name.toString());
    }
}
