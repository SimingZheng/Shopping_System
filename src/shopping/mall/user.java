package shopping.mall;

public class user {
    private String userName;
    private String password;
    private String membership;
    private int point;

    public user(String userName, String password, String membership, int point) {
        this.userName = userName;
        this.password = password;
        this.membership = membership;
        this.point = point;
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
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
}