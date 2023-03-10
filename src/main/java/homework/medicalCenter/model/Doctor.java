package homework.medicalCenter.model;

import homework.medicalCenter.Profession;
import homework.medicalCenter.parent.Person;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Doctor extends Person {

    private String email;
    private Profession profession;
    private Date[] patientDateAndTime;
    private int patientDateAndTimeIndex;

    public Doctor() {
        patientDateAndTimeIndex = 0;
        patientDateAndTime = new Date[0];
    }

    public Doctor(String id, String name, String surname, String phoneNumber, String email, Profession profession, int size) {
        super(id, name, surname, phoneNumber);
        patientDateAndTimeIndex = 0;
        this.patientDateAndTime = new Date[size];
        this.email = email;
        this.profession = profession;
    }

    private void extend() {
        Date[] arrayOne = new Date[patientDateAndTime.length + 1];
        System.arraycopy(patientDateAndTime, 0, arrayOne, 0, patientDateAndTime.length);
        patientDateAndTime = arrayOne;
    }


    public Date[] getPatientDateAndTime() {
        return patientDateAndTime;
    }

    public void setPatientDateAndTime(Date patientDateAndTime) {
        if (patientDateAndTimeIndex >= this.patientDateAndTime.length) {
            extend();
        }
        this.patientDateAndTime[patientDateAndTimeIndex++] = patientDateAndTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (patientDateAndTimeIndex != doctor.patientDateAndTimeIndex) return false;
        if (!Objects.equals(email, doctor.email)) return false;
        if (profession != doctor.profession) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(patientDateAndTime, doctor.patientDateAndTime);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(patientDateAndTime);
        result = 31 * result + patientDateAndTimeIndex;
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() +
                "email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", patientDateAndTime=" + Arrays.toString(patientDateAndTime) +
                "} ";
    }
}
