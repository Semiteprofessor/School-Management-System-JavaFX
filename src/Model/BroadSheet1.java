package Model;

/**
 * Created by GeoCodec on 9/29/2019.
 */
public class BroadSheet1 {

    private int id;
    private String name;
    private String classes;
    private String term;

    public BroadSheet1(int id, String name, String classes, String term) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.term = term;
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

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
