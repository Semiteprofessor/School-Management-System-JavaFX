package tableModel;


import javafx.collections.ObservableList;

import java.time.LocalDate;

public class StudentTableModel {

    int id;
    String name;
    String classes;
    String gender;
    String dob;
    String admitted;
    String department;
    String disability;
    String designation;
    String contact;
    String address;
    String state;
    String year;

    public StudentTableModel(int id, String name, String classes, String gender, String dob, String admitted, String department, String disability, String designation, String contact, String address, String state, String year) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.gender = gender;
        this.dob = dob;
        this.admitted = admitted;
        this.department = department;
        this.disability = disability;
        this.designation = designation;
        this.contact = contact;
        this.address = address;
        this.state = state;
        this.year = year;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAdmitted() {
        return this.admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
