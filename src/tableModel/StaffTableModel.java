package tableModel;



public class StaffTableModel {

    int id;
    String name;
    String classes;
    String gender;
    String dob;
    String hired;
    String position;
    String department;
    String degree;
    String salary;
    String contact;
    String email;
    String address;
    String state;

    public StaffTableModel(int id, String name, String classes, String gender, String dob, String hired, String position, String department, String degree, String salary, String contact, String email, String address, String state) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.gender = gender;
        this.dob = dob;
        this.hired = hired;
        this.position = position;
        this.department = department;
        this.degree = degree;
        this.salary = salary;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.state = state;
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

    public String getHired() {
        return this.hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
