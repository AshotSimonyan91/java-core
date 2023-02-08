package homework.employee;

public class EmployeeStorage {
    private Employee[] array;
    private int arrayIndex;

    EmployeeStorage() {
        arrayIndex = 0;
        array = new Employee[10];
    }

    EmployeeStorage(int size) {
        arrayIndex = 0;
        array = new Employee[size];
    }

    private void extend() {
        Employee[] arrayOne = new Employee[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            arrayOne[i] = array[i];
        }
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
            System.err.println("\u001B[34m" + array[i] + "\u001B[0m");
        }
    }

    public void searchEmployeeByEmployeeID(String value) {
        boolean found = false;
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getEmployID().toLowerCase().contains(value.toLowerCase())) {
                System.out.println("\u001B[34m" + employee + "\u001B[0m");
                found = true;
            }
        }
        if (!found) System.err.println("No employee with ID" + value);
    }

    public void searchEmployeeByCompany(String value) {
        boolean found = false;
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getCompany().toLowerCase().contains(value.toLowerCase())) {
                System.out.println("\u001B[34m" + employee + "\u001B[0m");
                found = true;
            }
        }
        if (!found) System.err.println("No employee with " + value + "company");

    }

    public boolean checkID(String id) {
        for (int i = 0; i < arrayIndex; i++) {
            Employee employee = array[i];
            if (employee.getEmployID().equals(id)) {
                System.err.println("Employee with " + id + "ID already exists");
                return false;
            }
        }
        return true;
    }
}
