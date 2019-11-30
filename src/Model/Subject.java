package Model;

/**
 * Created by GeoCodec on 9/18/2019.
 */
public class Subject {

    int id;
    String subjects;
    String noOfsSubjects;

    public Subject(int id, String subjects, String noOfsSubjects) {
        this.id = id;
        this.subjects = subjects;
        this.noOfsSubjects = noOfsSubjects;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjects() {
        return this.subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getNoOfsSubjects() {
        return this.noOfsSubjects;
    }

    public void setNoOfsSubjects(String noOfsSubjects) {
        this.noOfsSubjects = noOfsSubjects;
    }
}


