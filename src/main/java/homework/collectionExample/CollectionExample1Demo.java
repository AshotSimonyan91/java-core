package homework.collectionExample;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionExample1Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CollectionExample1 name = new CollectionExample1(scanner, new ArrayList<>());
        boolean isTrue = true;

        name.add("Ashot");
        name.add("Armen");
        name.add("Poxos");
        name.add("Petros");
        name.add("Valod");

        while (isTrue) {
            System.out.println("Pleas input 0 for exit");
            System.out.println("Pleas input 1 for search name");
            System.out.println("Pleas input 2 for delete name");
            System.out.println("Pleas input 3 for add name by index");
            switch (scanner.nextLine()) {
                case "0" -> isTrue = false;
                case "1" -> {
                    System.out.println("Input name");
                    if (name.isExist(scanner)) {
                        System.out.println("Name exists");
                    }else {
                        System.out.println("Name doesn't exist");
                    }
                }
                case "2" -> {
                    System.out.println(name.toString());
                    System.out.println("Input name for delete");
                    name.deleteName(scanner);
                }
                case "3" -> {
                    System.out.println(name.toString());
                    System.out.println("input index and name");
                    name.inputNameByIndex(scanner, scanner);
                }
            }
        }
    }
}
