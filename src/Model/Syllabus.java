package Model;

/**
 * Created by GeoCodec on 10/2/2019.
 */
public class Syllabus {
    int id;
    String name;
    String teacher;
    String outline;
    String term;
    String note;

    public Syllabus(int id, String name, String teacher, String outline, String term, String note) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.outline = outline;
        this.term = term;
        this.note = note;
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

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getOutline() {
        return this.outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
