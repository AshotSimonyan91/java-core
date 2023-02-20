package homework.employee;

import homework.employee.storage.CompanyStorage;
import homework.employee.storage.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeStorage = new EmployeeStorage();
        CompanyStorage companyStorage = new CompanyStorage();
        Secretary secretary = new Secretary(scanner,employeeStorage,companyStorage);
        secretary.working();
    }
}
