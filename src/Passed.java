public class Passed {
    private String lib;
    private String date;
    private String time;

    public Passed(String lib, String date, String time) {
        this.lib = lib;
        this.date = date;
        this.time = time;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
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