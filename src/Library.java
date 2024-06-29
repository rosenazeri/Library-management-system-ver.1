public class Library {

    private String shenase1;
    private String libname;
    private String start;
    private String tableNum;
    private String address;

    public Library(String shenase1, String libname, String start, String tableNum, String address) {
        this.shenase1 = shenase1;
        this.libname = libname;
        this.start = start;
        this.tableNum = tableNum;
        this.address = address;
    }

    public String getShenase1() {
        return shenase1;
    }

    public void setShenase1(String shenase1) {
        this.shenase1 = shenase1;
    }

    public String getLibname() {
        return libname;
    }

    public void setLibname(String libname) {
        this.libname = libname;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}