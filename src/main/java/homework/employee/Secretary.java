package homework.employee;

import java.util.Arrays;
import java.util.Scanner;

public class Secretary {
    private boolean isTrue = true;
    private Scanner scanner = new Scanner(System.in);
    private EmployeeStorage employeeStorage = new EmployeeStorage();

    public void working() {
        while (isTrue) {
            System.out.println("Please input 0 for exit");
            System.out.println("Please input 1 for add employee");
            System.out.println("Please input 2 for print all employee");
            System.out.println("Please input 3 for search employee by employee ID");
            System.out.println("Please input 4 for search employee by company name");
            switch (scanner.nextLine()) {
                case "0" -> isTrue = false;
                case "1" -> addEmployee();
                case "2" -> employeeStorage.print();
                case "3" -> searchEmployeeByID();
                case "4" -> searchEmployeeByCompany();
            }
        }
    }

    private void addEmployee(){
        Employee employee = new Employee();
        System.out.println("\u001B[33m" + "Please input employee name: " + "\u001B[0m");
        employee.setName(scanner.nextLine());

        System.out.println("\u001B[33m" + "Please input employee surname: " + "\u001B[0m");
        employee.setSurname(scanner.nextLine());

        System.out.println("\u001B[33m" + "Please input employee ID: " + "\u001B[0m");
        boolean isIDNotExists = true;
        while (isIDNotExists) {
            String employeeID = scanner.nextLine();
            if (employeeStorage.checkID(employeeID)) {
                employee.setID(employeeID);
                isIDNotExists = false;
                break;
            }
            System.err.println("Please try again");
        }

        System.out.println("\u001B[33m" + "Please input employee salary: " + "\u001B[0m");
        boolean isSalaryCorrect = true;
        while (isSalaryCorrect) {
            String sal = scanner.nextLine();
            if (employee.isSalaryDigit(sal)) {
                employee.setSalary(Double.parseDouble(sal));
                isSalaryCorrect = false;
                break;
            }
            System.err.println("Please input only numbers");
        }

        System.out.println("\u001B[33m" + "Please input employee company: " + "\u001B[0m");
        employee.setCompany(scanner.nextLine());

        System.out.println("\u001B[33m" + "Please input employee position: " + "\u001B[0m");
        employee.setPosition(scanner.nextLine());

        employeeStorage.add(employee);
        System.err.println("Employee added");
    }

    private void searchEmployeeByID () {
        System.out.println("\u001B[33m" + "Please input employee ID for search" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee employee = employeeStorage.searchEmployeeByEmployeeID(str);
        if (employee == null){
            System.err.println("No employee with ID " + str);
            return;
        }
        System.out.println("\u001B[34m" + employee + "\u001B[0m");
    }

    private void searchEmployeeByCompany(){
        System.out.println("\u001B[33m" + "Please input employee company for search" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee[] employee = employeeStorage.searchEmployeeByCompany(str);
        if (employee == null){
            System.err.println("No employee with " + str + " company");
            return;
        }
        System.out.println("\u001B[34m" + Arrays.toString(employee) + "\u001B[0m");
    }
}