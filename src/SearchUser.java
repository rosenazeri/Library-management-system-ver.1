
public class SearchUser {
    private String id1;
    private String password;
    private String nameOrLast;

    // Constructor
    public SearchUser(String id1, String password, String nameOrLast) {
        this.id1 = id1;
        this.password = password;
        this.nameOrLast = nameOrLast;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameOrLast() {
        return nameOrLast;
    }

    public void setNameOrLast(String nameOrLast) {
        this.nameOrLast = nameOrLast;
    }
}