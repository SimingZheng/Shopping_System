package shopping.model;

import java.util.HashMap;
import java.util.Map;

public class userInitial {

    private Map<String, user> userMap;
    private String discount;
    private String deliverFee;
    private String [] Array_MembershipDiscount = new String[2];
    private String [] Array_DeliverFee = new String[2];;
    private int current_point;

    public userInitial(){
        init();
    }

    public userInitial(Map<String, user> userMap){
        if (userMap==null || userMap.isEmpty()){
            init();
        }
        this.userMap = userMap;

    }

    public void init(){
        userMap = new HashMap<String, user>();
        userMap.put("1", new user("User1","123", "VIP", 2));
        userMap.put("2", new user("User2","123", "Gold",2));
        userMap.put("3", new user("User3","123 ", "Supreme",2));
        userMap.put("4", new user("User4","123", "General",2));
    }

    public Map<String, user> getUserMap() {
        return userMap;
    }

    public void setUserMap(String userName, int point) {
        userMap.put(userName, userMap.get(point));
    }

    public String [] getMememberhipDiscount(double total, String membership){
        switch (membership) {
            case "VIP":
                total *= 0.95;
                discount = " (5% discount)";
                break;
            case "Gold":
                total *= 0.9;
                discount = " (10% discount)";
                break;
            case "Supreme":
                total *= 0.8;
                discount = " (20% discount)";
                break;
            default:
                total = total*1;
                discount = " (no discount)";
                break;
        }
        Array_MembershipDiscount[0] = Double.toString(total);
        Array_MembershipDiscount[1] = discount;
        return Array_MembershipDiscount;
    }

    public int getCurrentPoint(double total){
        current_point = (int) (total / 50);
        return current_point;
    }

    public double getPointDiscount(double total, int point){
        total -= 5*point;
        if (total <= 0)
            total = 0;
        return total;
    }

    public String [] getDeliverFee(double total){
        if (total >= 100)
            deliverFee = "Free";
        else{
            total += 5;
            deliverFee = "5";
        }
        Array_DeliverFee[0] = Double.toString(total);
        Array_DeliverFee[1] = deliverFee;
        return Array_DeliverFee;
    }

    public user isLogin(String userName, String password) {
        user user = userMap.get(userName);
        if (user == null || !user.getPassword().equals(password)){
            return null;
        }
        return user;
    }
}

