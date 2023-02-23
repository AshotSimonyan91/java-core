package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.MedicalStorage;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MedicalAdministrator implements Commands {

    private boolean isTrue = true;
    private final Scanner scanner;
    private final MedicalStorage medicalStorage;

    public MedicalAdministrator(Scanner scanner, MedicalStorage medicalStorage) {
        this.scanner = scanner;
        this.medicalStorage = medicalStorage;
    }

    public void register() {
        while (isTrue) {
            printCommands();
            switch (scanner.nextLine()) {
                case EXIT -> isTrue = false;
                case ADD_DOCTOR -> addDoctor();
                case SEARCH_DOCTOR_BY_PROFESSION -> searchDoctorByProfession();
                case DELETE_DOCTOR_BY_ID -> deleteDoctorByID();
                case CHANGE_DOCTOR_DATA_BY_ID -> changeDoctorDataByID();
                case ADD_PATIENT -> addPatient();
                case PRINT_ALL_PATIENT_BY_DOCTOR -> printAllPatientByDoctor();
                case PRINT_TODAYS_PATIENTS -> printTodaysPatient();
            }
        }
    }

    private void printTodaysPatient() {
        Date date = new Date();
        String[] s1 = DateUtil.dateToString(date).split(" ");
        Patient[] allPatient = medicalStorage.getAllPatient();
        try {
            for (int i = 0; i < allPatient.length; i++) {
                String[] s = DateUtil.dateToString(allPatient[i].getRegisterDate()).split(" ");
                if (s[0].equals(s1[0])) {
                    System.out.println(allPatient[i]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No more patient");
        }
    }

    private void printAllPatientByDoctor() {
        try {
            System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        } catch (NullPointerException e) {
            System.out.println("First add doctor");
            return;
        }
        System.out.println("Please input doctor id");
        String doctorId = scanner.nextLine();
        Patient[] allPatient = medicalStorage.getAllPatient();
        try {
            for (int i = 0; i < allPatient.length; i++) {
                if (doctorId.equals(allPatient[i].getDoctor().getId())) {
                    System.out.println(allPatient[i]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No more patient");
        }
    }

    private void addPatient() {
        Patient patient = new Patient();
        System.out.println("Please input patient's id");
        boolean isIDNotExists = true;
        while (isIDNotExists) {
            String patientID = scanner.nextLine();
            if (medicalStorage.checkID(patientID)) {
                patient.setId(patientID);
                isIDNotExists = false;
                break;
            }
            System.err.println("Please try again");
            try {
                System.out.println(Arrays.toString(medicalStorage.getAllPatient()));
            } catch (NullPointerException e) {
                System.out.println("Patient's not exist");
            }
        }
        System.out.println("Please input patient's name");
        patient.setName(scanner.nextLine());
        System.out.println("Please input patient's surname");
        patient.setSurname(scanner.nextLine());
        System.out.println("Please input patient's phone number");
        patient.setPhoneNumber(scanner.nextLine());
        try {
            System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        } catch (NullPointerException e) {
            System.err.println("Please at first add doctor");
            return;
        }
        System.out.println("Please input doctor by doctor ID");
        String idStr = scanner.nextLine();
        System.out.println("Please input date and time  (dd/MM/yyyy HH:mm:ss)");
        String dateStr = scanner.nextLine();
        try {
            Date[] patientDateAndTime = medicalStorage.getDoctorByDoctorID(idStr).getPatientDateAndTime();
            for (int i = 0; i < patientDateAndTime.length; i++) {
                if (DateUtil.stringToDate(dateStr).equals(patientDateAndTime[i])) {
                    System.out.println("doctor busy in that time");
                    return;
                }
            }
            medicalStorage.registerPatientAtDoctor(idStr, DateUtil.stringToDate(dateStr));
            patient.setDoctor(medicalStorage.getDoctorByDoctorID(idStr));
            patient.setRegisterDate(DateUtil.stringToDate(dateStr));
        } catch (ParseException e) {
            System.out.println("Incorrect date format");
            return;
        } catch (NullPointerException e) {
            System.out.println("doctor with " + '\'' + idStr + '\'' + " not exist");
            return;
        }

        medicalStorage.add(patient);

        System.err.println("patient was added");

    }

    private void changeDoctorDataByID() {
        try {
            System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
            System.out.println("Please input doctor ID for change doctor data");
            Doctor doctorByDoctorID = medicalStorage.getDoctorByDoctorID(scanner.nextLine());
            System.out.println("Please input name");
            doctorByDoctorID.setName(scanner.nextLine());
            System.out.println("Please input surname");
            doctorByDoctorID.setSurname(scanner.nextLine());
            System.out.println("Please input phone number");
            doctorByDoctorID.setPhoneNumber(scanner.nextLine());
            System.out.println("Please input email");
            doctorByDoctorID.setEmail(scanner.nextLine());
            System.out.println("Please input profession");
            doctorByDoctorID.setProfession(scanner.nextLine());

            medicalStorage.add(doctorByDoctorID);
        } catch (NullPointerException e) {
            System.out.println("First add doctor");
        }
    }

    private void deleteDoctorByID() {
        try {
            System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
            System.out.println("Please input doctor ID for delete doctor");
            medicalStorage.deleteDoctorByID(scanner.nextLine());
        } catch (NullPointerException e) {
            System.out.println("First add doctor");
        }
    }

    private void searchDoctorByProfession() {
        try {
            System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        } catch (NullPointerException e) {
            System.err.println("First add doctor");
            return;
        }
        System.out.println("Please input profession for search doctor");
        String professionStr = scanner.nextLine();
        try {
            System.out.println(Arrays.toString(medicalStorage.getDoctorByProfession(professionStr)));
        } catch (NullPointerException e) {
            System.out.println("Doctor whit " + professionStr + " profession not exist");
        }
    }

    private void addDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Please input doctor's id");
        boolean isIDNotExists = true;
        while (isIDNotExists) {
            String doctorID = scanner.nextLine();
            if (medicalStorage.checkID(doctorID)) {
                doctor.setId(doctorID);
                isIDNotExists = false;
                break;
            }
            System.err.println("Please try again");
            System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        }
        System.out.println("Please input doctor's name");
        doctor.setName(scanner.nextLine());
        System.out.println("Please input doctor's surname");
        doctor.setSurname(scanner.nextLine());
        System.out.println("Please input doctor's phone number");
        doctor.setPhoneNumber(scanner.nextLine());
        System.out.println("Please input doctor's email");
        doctor.setEmail(scanner.nextLine());
        System.out.println("Please input doctor's profession");
        doctor.setProfession(scanner.nextLine());

        medicalStorage.add(doctor);

        System.err.println("Doctor was added.");
    }

}
