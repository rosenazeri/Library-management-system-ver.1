import java.util.ArrayList;

public class Thesis {
    private String shenase3;
    private String onvan;
    private String creatorName;
    private String professor;
    private String year2;
    private String code;
    private String shenase;
    private boolean isBorrowed = false;

    public Thesis(String shenase3, String onvan, String creatorName, String professor, String year2, String code, String shenase) {
        this.shenase3 = shenase3;
        this.onvan = onvan;
        this.creatorName = creatorName;
        this.professor = professor;
        this.year2 = year2;
        this.code = code;
        this.shenase = shenase;

    }

    private ArrayList<Thesis> thesisList = new ArrayList<>();

    public String getShenase3() {
        return shenase3;
    }

    public void setShenase3(String shenase3) {
        this.shenase3 = shenase3;
    }

    public String getOnvan() {
        return onvan;
    }

    public void setOnvan(String onvan) {
        this.onvan = onvan;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getYear2() {
        return year2;
    }

    public void setYear2(String year2) {
        this.year2 = year2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShenase() {
        return shenase;
    }

    public void setShenase(String shenase) {
        this.shenase = shenase;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void addThesis(Thesis thesis) {

        thesisList.add(thesis);
    }

}