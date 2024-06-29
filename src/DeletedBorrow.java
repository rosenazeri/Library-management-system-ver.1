public class DeletedBorrow {
    private String id;
    private String passwd;
    private String shenase1;
    private String shenase2;
    private String date;
    private String time;

    public DeletedBorrow(String id, String passwd, String shenase1, String shenase2, String date, String time) {
        this.id = id;
        this.passwd = passwd;
        this.shenase1 = shenase1;
        this.shenase2 = shenase2;
        this.date = date;
        this.time = time;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}