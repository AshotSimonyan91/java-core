package homework.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Secretary {
    private boolean isTrue = true;
    private final Scanner scanner;
    private final EmployeeStorage employeeStorage;
    SimpleDateFormat simpleDateFormat;

    public Secretary(Scanner scanner, EmployeeStorage employeeStorage,SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
        this.scanner = scanner;
        this.employeeStorage = employeeStorage;
    }

    public void working() {
        while (isTrue) {
            System.out.println("Please input 0 for exit");
            System.out.println("Please input 1 for add employee");
            System.out.println("Please input 2 for print all employee");
            System.out.println("Please input 3 for search employee by employee ID");
            System.out.println("Please input 4 for search employee by company name");
            System.out.println("Please input 5 for search employee by salary range");
            System.out.println("Please input 6 for change employee position by id");
            System.out.println("Please input 7 for print only active employees");
            System.out.println("Please input 8 for inactive employee by id ");
            System.out.println("Please input 9 for activate employee by id");
            switch (scanner.nextLine()) {
                case "0" -> isTrue = false;
                case "1" -> addEmployee();
                case "2" -> employeeStorage.print();
                case "3" -> searchEmployeeByID();
                case "4" -> searchEmployeeByCompany();
                case "5" -> searchEmployeeBySalaryRange();
                case "6" -> changeEmployeePositionByID();
                case "7" -> printAllActiveEmployees();
                case "8" -> inactiveEmployeeByID();
                case "9" -> activateEmployeeByID();

            }
        }
    }

    private void activateEmployeeByID() {
        System.out.println("\u001B[33m" + "Please input  ID for search employee" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeByEmployeeID(str);
        if (employee == null) {
            System.err.println("No employee with ID " + str);
            return;
        }
        if (employee.isActive()) {
            System.err.println("Employee already active");
            return;
        }
        employee.setActive(true);
        System.err.println("Employee active");
    }

    private void inactiveEmployeeByID() {
        System.out.println("\u001B[33m" + "Please input  ID for search employee" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeByEmployeeID(str);
        if (employee == null) {
            System.err.println("No employee with ID " + str);
            return;
        }
        if (!employee.isActive()) {
            System.err.println("Employee already inactive");
            return;
        }
        employee.setActive(false);
        System.err.println("Employee inactive");
    }

    private void printAllActiveEmployees() {
        Employee[] employee = employeeStorage.getAllActiveEmployee();
        if (employee == null) {
            System.err.println("No active employee ");
            return;
        }
        System.out.println("\u001B[34m" + Arrays.toString(employee) + "\u001B[0m");
    }

    private void changeEmployeePositionByID() {
        System.out.println("\u001B[33m" + "Please input employee ID for search and change position" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeByEmployeeID(str);
        if (employee == null) {
            System.err.println("No employee with ID " + str);
            return;
        }
        System.out.println("\u001B[33m" + "Please input employee new position" + "\u001B[0m");
        str = scanner.nextLine();
        employee.setPosition(str);
    }

    private void searchEmployeeBySalaryRange() {
        System.out.println("\u001B[33m" + "Please input employee salary range from min to max for search" + "\u001B[0m");
        boolean isSalaryCorrect = true;
        while (isSalaryCorrect) {
            System.out.print("min: ");
            String min = scanner.nextLine();
            System.out.print("max: ");
            String max = scanner.nextLine();
            if (isSalaryDigit(min) && isSalaryDigit(max)) {
                Employee[] employees = employeeStorage.getEmployeeBySalaryRange(Double.parseDouble(min), Double.parseDouble(max));
                System.out.println("\u001B[34m" + Arrays.toString(employees) + "\u001B[0m");
                isSalaryCorrect = false;
                break;
            }
            System.err.println("Please input only numbers");
        }
    }

    private void addEmployee() {
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
            if (isSalaryDigit(sal)) {
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

        System.out.println("\u001B[33m" + "Please input employee birthday date (example: DD/MM/YYYY): " + "\u001B[0m");
        try {
            employee.setDateOfBirthday(simpleDateFormat.parse(scanner.nextLine()));
        } catch (ParseException e) {
            System.out.println("Wrong date format " + e);
        }

        employee.setRegisterDate(new Date());

        employee.setActive(true);

        employeeStorage.add(employee);
        System.err.println("Employee added");
    }

    private void searchEmployeeByID() {
        System.out.println("\u001B[33m" + "Please input employee ID for search" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee employee = employeeStorage.getEmployeeByEmployeeID(str);
        if (employee == null) {
            System.err.println("No employee with ID " + str);
            return;
        }
        System.out.println("\u001B[34m" + employee + "\u001B[0m");
    }

    private void searchEmployeeByCompany() {
        System.out.println("\u001B[33m" + "Please input employee company for search" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee[] employee = employeeStorage.getEmployeeByCompany(str);
        if (employee == null) {
            System.err.println("No employee with " + str + " company");
            return;
        }
        System.out.println("\u001B[34m" + Arrays.toString(employee) + "\u001B[0m");
    }

    private boolean isSalaryDigit(String value) {
        int counter = 0;
        if (value.length() == 0) counter++;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (!Character.isDigit(c)) {
                counter++;
            }
        }
        if (counter > 0) return false;
        return true;
    }
}
