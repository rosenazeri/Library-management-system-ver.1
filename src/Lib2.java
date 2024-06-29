import java.util.ArrayList;

public class Lib2 {
    private String date;
    private String shenase1;
    private String tablenum;

    private ArrayList<Lib2> lib2List = new ArrayList<>();

    public Lib2(String date, String shenase1, String tablenum) {
        this.date = date;
        this.shenase1 = shenase1;
        this.tablenum = tablenum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShenase1() {
        return shenase1;
    }

    public void setShenase1(String shenase1) {
        this.shenase1 = shenase1;
    }

    public String getTablenum() {
        return tablenum;
    }
    public void setTablenum(String tablenum) {
        this.tablenum = tablenum;
    }
}