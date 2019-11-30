package Model;

/**
 * Created by GeoCodec on 9/9/2019.
 */
public class Bursary {

    int id;
    String name;
    String classes;
    String term;
    String first_payment;
    String second_payment;
    String third_payment;
    String actual_fee;
    String status;
    String mode_of_payment;
    String arrears;

    public Bursary(int id, String name, String classes, String term, String first_payment, String second_payment, String third_payment, String actual_fee, String status, String mode_of_payment, String arrears) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.term = term;
        this.first_payment = first_payment;
        this.second_payment = second_payment;
        this.third_payment = third_payment;
        this.actual_fee = actual_fee;
        this.status = status;
        this.mode_of_payment = mode_of_payment;
        this.arrears = arrears;
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

    public String getFirst_payment() {
        return this.first_payment;
    }

    public void setFirst_payment(String first_payment) {
        this.first_payment = first_payment;
    }

    public String getSecond_payment() {
        return this.second_payment;
    }

    public void setSecond_payment(String second_payment) {
        this.second_payment = second_payment;
    }

    public String getThird_payment() {
        return this.third_payment;
    }

    public void setThird_payment(String third_payment) {
        this.third_payment = third_payment;
    }

    public String getActual_fee() {
        return this.actual_fee;
    }

    public void setActual_fee(String actual_fee) {
        this.actual_fee = actual_fee;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMode_of_payment() {
        return this.mode_of_payment;
    }

    public void setMode_of_payment(String mode_of_payment) {
        this.mode_of_payment = mode_of_payment;
    }

    public String getArrears() {
        return this.arrears;
    }

    public void setArrears(String arrears) {
        this.arrears = arrears;
    }
}
