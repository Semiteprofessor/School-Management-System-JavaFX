package Model;

/**
 * Created by GeoCodec on 9/5/2019.
 */
public class Department {

    private int id;
    private String departments;
    private int noOfStudent;

    public Department(int id, String departments, int noOfStudent) {
        this.id = id;
        this.departments = departments;
        this.noOfStudent = noOfStudent;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return this.departments;
    }

    public void setDepartment(String department) {
        this.departments = department;
    }

    public int getNoOfStudent() {
        return this.noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }
}
