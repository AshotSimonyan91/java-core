package homework.medicalCenter;

import homework.medicalCenter.storage.MedicalStorage;

import java.util.Scanner;

public class MedicalCenterDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalStorage medicalStorage = new MedicalStorage();
        MedicalAdministrator medicalAdministrator = new MedicalAdministrator(scanner, medicalStorage);
        medicalAdministrator.register();
    }
}
