package Model;


public class Classes {

    private int classesID;
    private String classes;
    private int noOfStudents;

    public Classes(int classesID, String classes, int noOfStudents) {
        this.classesID = classesID;
        this.classes = classes;
        this.noOfStudents = noOfStudents;
    }

    public int getClassesID() {
        return this.classesID;
    }

    public void setClassesID(int classesID) {
        this.classesID = classesID;
    }

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getNoOfStudents() {
        return this.noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}
