import java.util.ArrayList;

public class ReserveSeat {
    private String id;
    private String passwd;
    private String shenase1;
    private String date;
    private String time1 ;
    private String time2 ;
    private static ArrayList<ReserveSeat> reserveSeatsList = new ArrayList<>();

    public ReserveSeat(String id, String passwd, String shenase1, String date, String time1 , String time2) {
        this.id = id;
        this.passwd = passwd;
        this.shenase1 = shenase1;
        this.date = date;
        this.time1 = time1;
        this.time2 = time2;
    }


    public static void setReserveSeatList(ArrayList<ReserveSeat> reserveSeatsList) {
        ReserveSeat.reserveSeatsList = reserveSeatsList;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }
    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
}