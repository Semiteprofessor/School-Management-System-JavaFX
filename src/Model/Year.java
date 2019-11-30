package Model;

/**
 * Created by GeoCodec on 9/5/2019.
 */
public class Year {


    private int id;
    private String years;
    private int noOfStudent;

    public Year(int id, String years, int noOfStudent) {
        this.id = id;
        this.years = years;
        this.noOfStudent = noOfStudent;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return this.years;
    }

    public void setYear(String year) {
        this.years = year;
    }

    public int getNoOfStudent() {
        return this.noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }
}
