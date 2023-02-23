package homework.medicalCenter.model;

import homework.medicalCenter.parent.Person;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person {

    private Doctor doctor;
    private Date registerDate;


    public Patient() {
        status = "patient";
    }

    public Patient(String id, String name, String surname, String phoneNumber, Doctor doctor, Date registerDate) {
        super(id, name, surname, phoneNumber);
        this.status = "patient";
        this.doctor = doctor;
        this.registerDate = registerDate;
    }

    @Override
    public String getStatus() {
        return super.getStatus();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(doctor, patient.doctor)) return false;
        return Objects.equals(registerDate, patient.registerDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" + "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", doctor=" + doctor +
                ", registerDate=" + DateUtil.dateToString(registerDate) +
                '}' + "\n";
    }
}
