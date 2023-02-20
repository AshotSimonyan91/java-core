package homework.employee.storage;

import homework.employee.model.Employee;

public class EmployeeStorage {
    private Employee[] array;
    private int arrayIndex;

    public EmployeeStorage() {
        arrayIndex = 0;
        array = new Employee[10];
    }

    EmployeeStorage(int size) {
        arrayIndex = 0;
        array = new Employee[size];
    }

    private void extend() {
        Employee[] arrayOne = new Employee[array.length + 10];
        System.arraycopy(array, 0, arrayOne, 0, array.length);
        array = arrayOne;
    }

    public void add(Employee item) {
        if (arrayIndex >= array.length) {
            extend();
        }
        array[arrayIndex] = item;
        arrayIndex++;
    }

    public void print() {
        for (int i = 0; i < arrayIndex; i++) {
            System.out.println("\u001B[34m" + array[i] + "\u001B[0m");
        }
        if (arrayIndex == 0) System.err.println("Didn't add any employee");
    }

    public Employee[] getAllActiveEmployee() {
        Employee[] arrayEmployee = new Employee[arrayIndex];
        int arrayEmployeeIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.isActive()) {
                arrayEmployee[arrayEmployeeIndex++] = employee;
            }
        }
        if (arrayEmployeeIndex == 0) return null;
        return arrayEmployee;
    }
    public Employee[] getAllInactiveEmployee() {
        Employee[] arrayEmployee = new Employee[arrayIndex];
        int arrayEmployeeIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (!employee.isActive()) {
                arrayEmployee[arrayEmployeeIndex++] = employee;
            }
        }
        if (arrayEmployeeIndex == 0) return null;
        return arrayEmployee;
    }

    public Employee getEmployeeByEmployeeID(String value) {
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getID().toLowerCase().contains(value.toLowerCase())) {
                return employee;
            }
        }
        return null;
    }

    public Employee[] getEmployeeByCompanyName(String value) {
        Employee[] arrayEmployee = new Employee[arrayIndex];
        int arrayEmployeeIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getCompany().getName().toLowerCase().contains(value.toLowerCase())) {
                arrayEmployee[arrayEmployeeIndex++] = employee;
            }
        }
        if (arrayEmployeeIndex == 0) return null;
        return arrayEmployee;
    }

    public boolean checkID(String id) {
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getID().equals(id)) {
                System.err.println("Employee with \"" + id + "\" ID already exists");
                return false;
            }
        }
        return true;
    }

    public Employee[] getEmployeeBySalaryRange(double min, double max) {
        Employee[] arrayEmployee = new Employee[arrayIndex];
        int arrayEmployeeIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getSalary() >= min && employee.getSalary() <= max) {
                arrayEmployee[arrayEmployeeIndex++] = employee;
            }
        }
        if (arrayEmployeeIndex == 0) return null;
        return arrayEmployee;
    }
}
