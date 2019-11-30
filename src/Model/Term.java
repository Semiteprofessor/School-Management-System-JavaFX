package Model;

/**
 * Created by GeoCodec on 9/10/2019.
 */
public class Term {

    int id;
    String terms;
    String noOfTerms;

    public Term(int id, String terms, String noOfTerms) {
        this.id = id;
        this.terms = terms;
        this.noOfTerms = noOfTerms;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getNoOfTerms() {
        return this.noOfTerms;
    }

    public void setNoOfTerms(String noOfTerms) {
        this.noOfTerms = noOfTerms;
    }
}
