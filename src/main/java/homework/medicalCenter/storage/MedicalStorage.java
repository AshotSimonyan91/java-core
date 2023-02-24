package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.parent.Person;

import java.util.Objects;

public class MedicalStorage {
    private Person[] array;
    private int arrayIndex;
    private int doctorCount;
    private int patientCount;

    public MedicalStorage() {
        doctorCount = 0;
        patientCount = 0;
        arrayIndex = 0;
        array = new Person[10];
    }

    MedicalStorage(int size) {
        doctorCount = 0;
        patientCount = 0;
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
        if (person.getStatus().equals("doctor")) {
            doctorCount++;
        } else {
            patientCount++;
        }
        arrayIndex++;
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
            System.err.println("Doctor deleted");
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
        Doctor[] arrayDoctor = new Doctor[doctorCount];
        int arrayPersonIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Person doctor = array[i];
            if (doctor.getStatus().equals("doctor")) {
                arrayDoctor[arrayPersonIndex++] = (Doctor) doctor;
            }
        }
        return arrayDoctor;
    }

    public Patient[] getAllPatient() {
        Patient[] arrayPatient = new Patient[patientCount];
        int arrayPersonIndex = 0;
        for (int i = 0; i < arrayIndex; i++) {
            Person patient = array[i];
            if (patient.getStatus().equals("patient")) {
                arrayPatient[arrayPersonIndex++] = (Patient) patient;
            }
        }
        return arrayPatient;
    }

    public Doctor[] getDoctorByProfession(String value) {
        Doctor[] arrayDoctor = new Doctor[doctorCount];
        Doctor[] allDoctor = getAllDoctor();
        int arrayPersonIndex = 0;
        for (int i = 0; i < allDoctor.length; i++) {
            if (Objects.equals(allDoctor[i].getProfession(),value)) {
                arrayDoctor[arrayPersonIndex++] = allDoctor[i];
            }
        }
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
