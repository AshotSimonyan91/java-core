package homework.employee.model;

import homework.employee.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String ID;
    private double salary;
    private Company company;
    private String position;
    private boolean active;
    private Date registerDate;
    private Date dateOfBirthday;

    public Employee() {
        name = "";
        surname = "";
        ID = "";
        salary = 0.0;
        position = "";
    }

    public Employee(String name, String surname, String ID, double salary, Company company, String position, boolean active, Date registerDate, Date dateOfBirthday) {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.salary = salary;
        this.company = company;
        this.position = position;
        this.active = active;
        this.registerDate = registerDate;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0) return false;
        if (active != employee.active) return false;
        if (!Objects.equals(name, employee.name)) return false;
        if (!Objects.equals(surname, employee.surname)) return false;
        if (!Objects.equals(ID, employee.ID)) return false;
        if (!Objects.equals(company, employee.company)) return false;
        if (!Objects.equals(position, employee.position)) return false;
        if (!Objects.equals(registerDate, employee.registerDate))
            return false;
        return Objects.equals(dateOfBirthday, employee.dateOfBirthday);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (ID != null ? ID.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (dateOfBirthday != null ? dateOfBirthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ID='" + ID + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                ", position='" + position + '\'' +
                ", active=" + active +
                ", registerDate=" + DateUtil.dateToString(registerDate) +
                ", dateOfBirthday=" + DateUtil.dateToString(dateOfBirthday) +
                '}';
    }
}
