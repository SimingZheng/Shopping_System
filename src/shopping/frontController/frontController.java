package shopping.frontController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class frontController {

    private dispatcher dispatcher;

    public frontController(){
        dispatcher = new dispatcher();
    }
    @Test
    private boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully.");
        return true;
    }
    @Test
    @DisplayName("track membership")
    private void trackMembership(String membership){
//        System.out.println("membership: " + membership);
        if(membership.equalsIgnoreCase("VIP"))
            Assertions.assertEquals("VIP", membership);
        else if (membership.equalsIgnoreCase("Gold"))
            Assertions.assertEquals("Gold", membership,"Gold");
        else if (membership.equalsIgnoreCase("Supreme"))
            Assertions.assertEquals("Supreme", membership);
        else if (membership.equalsIgnoreCase("General"))
            Assertions.assertEquals("General", membership);
    }
    @Test
    public void dispatchRequest(String membership){

        trackMembership(membership);

        if(isAuthenticUser()){
            dispatcher.dispatch(membership);
        }
    }
}