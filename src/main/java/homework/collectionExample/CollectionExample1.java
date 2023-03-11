package homework.collectionExample;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionExample1 {

    Scanner scanner;
    ArrayList<String> names;

    boolean isExist = false;

    public CollectionExample1(Scanner scanner, ArrayList<String> name) {
        this.scanner = scanner;
        this.names = name;
    }


    public void add(String name) {
        this.names.add(name);
    }

    public void isExist(Scanner scanner) {
        String s = scanner.nextLine();
        for (String nameStr : names) {
            if (nameStr.equalsIgnoreCase(s)) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.println("Name exists");
        }else {
            System.out.println("Name doesn't exist");
        }
    }


    public void deleteName(Scanner scanner) {
        String s = scanner.nextLine();
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(s)) {
                names.remove(i);
            }
        }
        System.out.println(names.toString());
    }

    public void inputNameByIndex(Scanner scanner, Scanner scanner1) {
        int index = Integer.parseInt(scanner.nextLine());
        String s = scanner1.nextLine();
        if (index < 0 || index > names.size()) {
            System.out.println("Incorrect index");
            return;
        }
        names.add(index, s);
        System.out.println(names.toString());
    }

    @Override
    public String toString() {
        return names.toString();

    }
}
