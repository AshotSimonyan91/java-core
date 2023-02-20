package homework.employee.storage;

import homework.employee.model.Company;

public class CompanyStorage {
    private Company[] array;
    private int arrayIndex;

    public CompanyStorage() {
        arrayIndex = 0;
        array = new Company[10];
    }

    CompanyStorage(int size) {
        arrayIndex = 0;
        array = new Company[size];
    }

    private void extend() {
        Company[] arrayOne = new Company[array.length + 10];
        System.arraycopy(array, 0, arrayOne, 0, array.length);
        array = arrayOne;
    }

    public void add(Company company) {
        if (arrayIndex >= array.length) {
            extend();
        }
        array[arrayIndex] = company;
        arrayIndex++;
    }

    public void print() {
        for (int i = 0; i < arrayIndex; i++) {
            System.out.println("\u001B[34m" + array[i] + "\u001B[0m");
        }
        if (arrayIndex == 0) System.err.println("Didn't add any company");
    }


    public Company getCompanyByID(String id) {
        for (int i = 0; i < arrayIndex; i++) {
            if (array[i].getId().equals(id)) {
                return array[i];
            }
        }
        return null;
    }

}
