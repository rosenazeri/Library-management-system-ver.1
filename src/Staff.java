import java.util.ArrayList;

public class Staff {
    private String id;
    private String passwd;
    private String name;
    private String lastname;
    private String nationalNum;
    private String year;
    private String address;

    public Staff(String id, String passwd, String name, String lastname, String nationalNum, String year, String address) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.lastname = lastname;
        this.nationalNum = nationalNum;
        this.year = year;
        this.address = address;
    }

    private ArrayList<Staff> staffList = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalNum() {
        return nationalNum;
    }

    public void setNationalNum(String nationalNum) {
        this.nationalNum = nationalNum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

}