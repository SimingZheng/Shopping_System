package shopping.frontController;

import org.junit.jupiter.api.*;

public class frontController {

    private dispatcher dispatcher;

    public frontController(){
        dispatcher = new dispatcher();
    }
    boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully.");
        return true;
    }
    void trackMembership(String membership) {
        System.out.println("membership: " + membership);
    }
    @Test
    void testMembership(){
        frontController controller = new frontController();
        Assertions.assertTrue(controller.isAuthenticUser());
    }

    public void dispatchRequest(String membership){

        trackMembership(membership);
        if(isAuthenticUser()){
            dispatcher.dispatch(membership);
        }
    }
}