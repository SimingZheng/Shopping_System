package shopping.mall;

import shopping.deliverFee.contextFee;
import shopping.deliverFee.fee;
import shopping.deliverFee.nofee;
import shopping.membership.membershipIdentify;

import java.util.HashMap;
import java.util.Map;

public class userInitial {

    private Map<String, user> userMap;
    private String discount;
    private String deliverFee;
    private String [] Array_MembershipDiscount = new String[2];
    private String [] Array_DeliverFee = new String[2];
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
        userMap.put("3", new user("User3","123", "Supreme",2));
        userMap.put("4", new user("User4","123", "General",2));
    }

    public Map<String, user> getUserMap() {
        return userMap;
    }

    public void setUserMap(String userName, int point) {
        userMap.put(userName, userMap.get(point));
    }

    public String [] getMemberhipDiscount(double total, String membership){
        membershipIdentify membershipIdentify = new membershipIdentify();
        Array_MembershipDiscount = membershipIdentify.getDiscount(total, membership);
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
        if (total >= 100) {
            contextFee context = new contextFee(new nofee());
            Array_DeliverFee = context.executeFee(total);
        }else{
            contextFee context = new contextFee(new fee());
            Array_DeliverFee = context.executeFee(total);
        }
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

