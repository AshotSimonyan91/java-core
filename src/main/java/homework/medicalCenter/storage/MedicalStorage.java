package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.parent.Person;

import java.util.Date;

public class MedicalStorage {
    private Person[] array;
    private int arrayIndex;

    public MedicalStorage() {
        arrayIndex = 0;
        array = new Person[10];
    }

    MedicalStorage(int size) {
        arrayIndex = 0;
        array = new Person[size];
    }

    private void extend() {
        Person[] arrayOne = new Person[array.length + 10];
        System.arraycopy(array, 0, arrayOne, 0, array.length);
        array = arrayOne;
    }

    public void add(Person person) {
        if (arrayIndex >= array.length) {
            extend();
        }
        for (int i = 0; i < arrayIndex; i++) {
            if (array[i].getId().equals(person.getId())) {
                array[i] = person;
                return;
            }
        }
        array[arrayIndex] = person;
        arrayIndex++;
    }

    public void registerPatientAtDoctor(String id, Date date) {
        try {
            Doctor doctorByDoctorID = getDoctorByDoctorID(id);
            doctorByDoctorID.setPatientDateAndTime(date);
        } catch (NullPointerException e) {
            System.out.println("doctor with " + '\'' + id + '\'' + " not exist");
        }
    }

    public void deleteDoctorByID(String id) {
        int doctorCount = 0;
        int index = 0;
        for (int i = 0; i < arrayIndex; i++) {
            if (array[i].getId().equals(id)) {
                index = i;
                doctorCount++;
            }
        }
        if (doctorCount > 0) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            arrayIndex--;
            return;
        }
        System.out.println("Doctor whit " + id + " not found");
    }

    public Doctor getDoctorByDoctorID(String id) {
        for (int i = 0; i < arrayIndex; i++) {
            Doctor doctor = (Doctor) array[i];
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        throw new NullPointerException();
    }

    public Doctor[] getAllDoctor() {
        Doctor[] arrayDoctor = new Doctor[arrayIndex];
        int arrayPersonIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Person doctor = array[i];
            if (doctor.getStatus().equals("doctor")) {
                arrayDoctor[arrayPersonIndex++] = (Doctor) doctor;
            }
        }
        if (arrayPersonIndex == 0) throw new NullPointerException();
        return arrayDoctor;
    }

    public Patient[] getAllPatient() {
        Patient[] arrayPatient = new Patient[arrayIndex];
        int arrayPersonIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Person patient = array[i];
            if (patient.getStatus().equals("patient")) {
                arrayPatient[arrayPersonIndex++] = (Patient) patient;
            }
        }
        if (arrayPersonIndex == 0) throw new NullPointerException();
        return arrayPatient;
    }

    public Doctor[] getDoctorByProfession(String value) {
        Doctor[] arrayDoctor = new Doctor[arrayIndex];
        int arrayPersonIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Doctor doctor = (Doctor) array[i];
            if (doctor.getProfession().equals(value)) {
                arrayDoctor[arrayPersonIndex++] = doctor;
            }
        }
        if (arrayPersonIndex == 0) throw new NullPointerException();
        return arrayDoctor;
    }

    public boolean checkID(String id) {
        for (int i = 0; i < arrayIndex; i++) {
            Person person = array[i];
            if (person.getId().equals(id)) {
                System.err.println("\"" + id + "\" ID already busy");
                return false;
            }
        }
        return true;
    }

}
