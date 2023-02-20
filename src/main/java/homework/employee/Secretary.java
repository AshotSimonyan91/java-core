package homework.employee;

import homework.employee.model.Company;
import homework.employee.model.Employee;
import homework.employee.storage.CompanyStorage;
import homework.employee.storage.EmployeeStorage;
import homework.employee.util.DateUtil;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Secretary implements Commands {
    private boolean isTrue = true;
    private final Scanner scanner;
    private final EmployeeStorage employeeStorage;
    private final CompanyStorage companyStorage;

    public Secretary(Scanner scanner, EmployeeStorage employeeStorage, CompanyStorage companyStorage) {
        this.companyStorage = companyStorage;
        this.scanner = scanner;
        this.employeeStorage = employeeStorage;
    }

    public void working() {
        while (isTrue) {
            printCommands();
            switch (scanner.nextLine()) {
                case EXIT -> isTrue = false;
                case ADD_EMPLOYEE -> addEmployee();
                case ADD_COMPANY -> addCompany();
                case PRINT_EMPLOYEE -> employeeStorage.print();
                case SEARCH_EMPLOYEE_BY_ID -> searchEmployeeByID();
                case SEARCH_EMPLOYEE_BY_COMPANY_ID -> searchEmployeeByCompanyID();
                case SEARCH_EMPLOYEE_BY_SALARY_RANGE -> searchEmployeeBySalaryRange();
                case CHANGE_EMPLOYEE_POSITION_BY_ID -> changeEmployeePositionByID();
                case PRINT_ALL_ACTIVE_EMPLOYEES -> printAllActiveEmployees();
                case INACTIVATE_EMPLOYEE_BY_ID -> inactivateEmployeeByID();
                case ACTIVATE_EMPLOYEE_BY_ID -> activateEmployeeByID();
                case PRINT_ALL_COMPANIES -> companyStorage.print();
            }
        }
    }

    private void addCompany() {
        System.out.println("\u001B[33m" + "Please input company ID : " + "\u001B[0m");
        String idStr = scanner.nextLine();
        if (companyStorage.getCompanyByID(idStr) == null) {
            Company company = new Company();
            company.setId(idStr);
            System.out.println("\u001B[33m" + "Please input company name : " + "\u001B[0m");
            company.setName(scanner.nextLine());
            System.out.println("\u001B[33m" + "Please input company address : " + "\u001B[0m");
            company.setAddress(scanner.nextLine());
            System.out.println("\u001B[33m" + "Please input company phone number : " + "\u001B[0m");
            company.setPhoneNumber(scanner.nextLine());
            companyStorage.add(company);
            System.err.println("Company was added");
        } else {
            System.err.println("Company with " + idStr + " already exist");
        }

    }

    private void activateEmployeeByID() {
        System.out.println(Arrays.toString(employeeStorage.getAllInactiveEmployee()));
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

    private void inactivateEmployeeByID() {
        System.out.println(Arrays.toString(employeeStorage.getAllActiveEmployee()));
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

        companyStorage.print();
        System.out.println("\u001B[33m" + "Please input employee company by company ID: " + "\u001B[0m");
        employee.setCompany(companyStorage.getCompanyByID(scanner.nextLine()));
        employee.getCompany().setEmployeeCount(employee.getCompany().getEmployeeCount() + 1);

        System.out.println("\u001B[33m" + "Please input employee position: " + "\u001B[0m");
        employee.setPosition(scanner.nextLine());

        System.out.println("\u001B[33m" + "Please input employee birthday date (example: DD/MM/YYYY): " + "\u001B[0m");
        try {
            employee.setDateOfBirthday(DateUtil.stringToDate(scanner.nextLine()));
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

    private void searchEmployeeByCompanyID() {
        companyStorage.print();
        System.out.println("\u001B[33m" + "Please input employee company for search" + "\u001B[0m");
        String str = scanner.nextLine();
        Employee[] employee = employeeStorage.getEmployeeByCompanyName(str);
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
