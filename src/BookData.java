import java.util.ArrayList;

public class BookData {
    private String Bcode;
    private String onvan;
    private String creator;
    private String pub;
    private String year2;
    private String existnum;
    private String code;
    private String shenase2;

    public BookData(String Bcode, String onvan, String creator, String pub, String year2, String existnum, String code, String shenase2) {
        this.Bcode = Bcode;
        this.onvan = onvan;
        this.creator = creator;
        this.pub = pub;
        this.year2 = year2;
        this.existnum = existnum;
        this.code = code;
        this.shenase2 = shenase2;
    }

    private ArrayList<BookData> bookDataList = new ArrayList<>();

    public String getBcode() {
        return Bcode;
    }

    public void setBcode(String Bcode) {
        this.Bcode = Bcode;
    }

    public String getOnvan() {
        return onvan;
    }

    public void setOnvan(String onvan) {
        this.onvan = onvan;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getYear2() {
        return year2;
    }

    public void setYear2(String year2) {
        this.year2 = year2;
    }

    public String getExistnum() {
        return existnum;
    }

    public void setExistnum(String existnum) {
        this.existnum = existnum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShenase2() {
        return shenase2;
    }

    public void setShenase2(String shenase2) {
        this.shenase2 = shenase2;
    }

    public void addBookData(BookData bookData) {
        bookDataList.add(bookData);
    }


}