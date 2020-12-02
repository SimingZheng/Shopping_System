package shopping.model;

public class user {
    private String userName;
    private String password;
    private String membership;

    public user(String userName, String password, String membership) {
        this.userName = userName;
        this.password = password;
        this.membership = membership;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMembership() {
        return membership;
    }
    public void setMembership(String membership) {
        this.membership = membership;
    }
}