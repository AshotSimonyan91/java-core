package homework.collectionExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionExample1 {

    private final Scanner scanner;
    private final List<String> names;

    public CollectionExample1(Scanner scanner, ArrayList<String> name) {
        this.scanner = scanner;
        this.names = name;
    }


    public void add(String name) {
        this.names.add(name);
    }

    public boolean isExist(Scanner scanner) {
        String s = scanner.nextLine();
        for (String nameStr : names) {
            if (nameStr.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }


    public void deleteName(Scanner scanner) {
        String s = scanner.nextLine();
        names.removeIf(name->name.equalsIgnoreCase(s));
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
