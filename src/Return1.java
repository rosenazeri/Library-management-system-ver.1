import java.util.ArrayList;

public class Return1 {
    private String id;
    private String passwd;
    private String shenase1;
    private String shenase2;
    private String date2;
    private String time2;

    private static ArrayList<Return1> return1List = new ArrayList<>();

    public Return1(String id, String passwd, String shenase1, String shenase2, String date2, String time2) {
        this.id = id;
        this.passwd = passwd;
        this.shenase1 = shenase1;
        this.shenase2 = shenase2;
        this.date2 = date2;
        this.time2 = time2;
    }

    public static ArrayList<Return1> getReturnList() {
        return new ArrayList<>(return1List);
    }

    public static void setReturnListList(ArrayList<Return1> returnList) {
        Return1.return1List = return1List;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getShenase1() {
        return shenase1;
    }

    public void setShenase1(String shenase1) {
        this.shenase1 = shenase1;
    }

    public String getShenase2() {
        return shenase2;
    }

    public void setShenase2(String shenase2) {
        this.shenase2 = shenase2;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
}