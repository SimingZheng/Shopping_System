package shopping.model;

import java.util.HashMap;
import java.util.Map;

public class userInitial {

    private Map<String, user> userMap;

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

    public user isLogin(String userName, String password) {
        user user = userMap.get(userName);
        if (user == null || !user.getPassword().equals(password)){
            return null;
        }
        return user;
    }
}

