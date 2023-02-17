package homework.employee;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Secretary secretary = new Secretary(scanner,employeeStorage,simpleDateFormat);
        secretary.working();
    }
}
