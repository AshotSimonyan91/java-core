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
        String[] todayDateStr = DateUtil.dateToString(date).split(" ");
        Patient[] allPatient = medicalStorage.getAllPatient();
        try {
            for (int i = 0; i < allPatient.length; i++) {
                String[] patientDateStr = DateUtil.dateToString(allPatient[i].getRegisterDate()).split(" ");
                if (patientDateStr[0].equals(todayDateStr[0])) {
                    System.out.println(allPatient[i]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No more patient");
        }
    }

    private void printAllPatientByDoctor() {
        if (medicalStorage.getAllDoctor().length == 0) {
            System.out.println("First add doctor");
            return;
        }
        System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
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
            System.out.println(Arrays.toString(medicalStorage.getAllPatient()));
        }
        System.out.println("Please input patient's name");
        patient.setName(scanner.nextLine());
        System.out.println("Please input patient's surname");
        patient.setSurname(scanner.nextLine());
        System.out.println("Please input patient's phone number");
        patient.setPhoneNumber(scanner.nextLine());
        if (medicalStorage.getAllDoctor().length == 0) {
            System.out.println("First add doctor");
            return;
        }
        System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        System.out.println("Please input doctor by doctor ID");
        String idStr = scanner.nextLine();
        System.out.println("Please input date and time  (dd/MM/yyyy HH:mm)");
        String dateStr = scanner.nextLine();
        if (medicalStorage.getDoctorByDoctorID(idStr) == null) {
            System.out.println("doctor with " + '\'' + idStr + '\'' + " not exist");
            return;
        }
        Date[] patientDateAndTime = medicalStorage.getDoctorByDoctorID(idStr).getPatientDateAndTime();
        try {
            for (int i = 0; i < patientDateAndTime.length; i++) {
                if (DateUtil.stringToDate(dateStr).equals(patientDateAndTime[i])) {
                    System.out.println("doctor busy in that time");
                    return;
                }
            }
            Doctor doctorByDoctorID = medicalStorage.getDoctorByDoctorID(idStr);
            doctorByDoctorID.setPatientDateAndTime(DateUtil.stringToDate(dateStr));
            patient.setDoctor(medicalStorage.getDoctorByDoctorID(idStr));
            patient.setRegisterDate(DateUtil.stringToDate(dateStr));
        } catch (ParseException e) {
            System.out.println("Incorrect date format");
            return;
        }

        medicalStorage.add(patient);

        System.err.println("patient was added");

    }

    private void changeDoctorDataByID() {
        if (medicalStorage.getAllDoctor().length == 0) {
            System.out.println("First add doctor");
            return;
        }
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
        System.err.println("e.g. FAMILY_PHYSICIANS, INTERNISTS, EMERGENCY_PHYSICIANS, PSYCHIATRISTS");
        String professionStr = scanner.nextLine();
        switch (professionStr.toUpperCase()) {
            case "FAMILY_PHYSICIANS" -> doctorByDoctorID.setProfession(Profession.FAMILY_PHYSICIANS);
            case "INTERNISTS" -> doctorByDoctorID.setProfession(Profession.INTERNISTS);
            case "EMERGENCY_PHYSICIANS" -> doctorByDoctorID.setProfession(Profession.EMERGENCY_PHYSICIANS);
            case "PSYCHIATRISTS" -> doctorByDoctorID.setProfession(Profession.PSYCHIATRISTS);
            default -> {
                System.out.println("Wrong profession");
                return;
            }
        }
    }

    private void deleteDoctorByID() {
        if (medicalStorage.getAllDoctor().length == 0) {
            System.out.println("First add doctor");
            return;
        }
        System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        System.out.println("Please input doctor ID for delete doctor");
        String idStr = scanner.nextLine();
        medicalStorage.deleteDoctorByID(idStr);
    }

    private void searchDoctorByProfession() {
        if (medicalStorage.getAllDoctor().length == 0 || medicalStorage.getAllDoctor()[0] == null) {
            System.out.println("First add doctor");
            return;
        }
        System.out.println(Arrays.toString(medicalStorage.getAllDoctor()));
        System.out.println("Please input profession for search doctor");
        String professionStr = scanner.nextLine();
        if (medicalStorage.getDoctorByProfession(professionStr)[0] == null) {
            System.out.println("Doctor whit " + professionStr + " profession not exist");
            return;
        }
        System.out.println(Arrays.toString(medicalStorage.getDoctorByProfession(professionStr)));

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
        System.err.println("e.g. FAMILY_PHYSICIANS, INTERNISTS, EMERGENCY_PHYSICIANS, PSYCHIATRISTS");
        String professionStr = scanner.nextLine();
        switch (professionStr.toUpperCase()) {
            case "FAMILY_PHYSICIANS" -> doctor.setProfession(Profession.FAMILY_PHYSICIANS);
            case "INTERNISTS" -> doctor.setProfession(Profession.INTERNISTS);
            case "EMERGENCY_PHYSICIANS" -> doctor.setProfession(Profession.EMERGENCY_PHYSICIANS);
            case "PSYCHIATRISTS" -> doctor.setProfession(Profession.PSYCHIATRISTS);
            default -> {
                System.out.println("Wrong profession");
                return;
            }
        }


        medicalStorage.add(doctor);

        System.err.println("Doctor was added.");
    }

}
