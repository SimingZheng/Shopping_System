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
        userMap.put("1", new user("1","1"));
    }

    public Map<String, user> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, user> userMap) {
        this.userMap = userMap;
    }

    public user isLogin(String userName, String password) {
        user user = userMap.get(userName);
        if (user == null || !user.getPassword().equals(password)){
            return null;
        }
        return user;
    }
}

