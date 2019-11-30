package Model;

/**
 * Created by GeoCodec on 9/10/2019.
 */
public class Status {

    int id;
    String status;
    String noOfStatus;

    public Status(int id, String status, String noOfStatus) {
        this.id = id;
        this.status = status;
        this.noOfStatus = noOfStatus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNoOfStatus() {
        return this.noOfStatus;
    }

    public void setNoOfStatus(String noOfStatus) {
        this.noOfStatus = noOfStatus;
    }
}
