package Model;

/**
 * Created by GeoCodec on 10/8/2019.
 */
public class Attendance {

    int id;
    String name;
    String classes;
    String term;
    String date;
    String attendance;
    String excuse;
    int totaldays;
    int totalpresent;
    int totalabsent;

    public Attendance(int id, String name, String classes, String term, String date, String attendance, String excuse, int totaldays, int totalpresent, int totalabsent) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.term = term;
        this.date = date;
        this.attendance = attendance;
        this.excuse = excuse;
        this.totaldays = totaldays;
        this.totalpresent = totalpresent;
        this.totalabsent = totalabsent;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return this.attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getExcuse() {
        return this.excuse;
    }

    public void setExcuse(String excuse) {
        this.excuse = excuse;
    }

    public int getTotaldays() {
        return this.totaldays;
    }

    public void setTotaldays(int totaldays) {
        this.totaldays = totaldays;
    }

    public int getTotalpresent() {
        return this.totalpresent;
    }

    public void setTotalpresent(int totalpresent) {
        this.totalpresent = totalpresent;
    }

    public int getTotalabsent() {
        return this.totalabsent;
    }

    public void setTotalabsent(int totalabsent) {
        this.totalabsent = totalabsent;
    }
}
