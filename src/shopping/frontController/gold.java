package shopping.frontController;

import shopping.mallBackend.menu;

public class gold {
    private String [] ArrayUser = new String[3];
    public void generate() {
        ArrayUser[0] = "Gold_user";
        ArrayUser[1] = "Gold";
        ArrayUser[2] = "2";

        String name = ArrayUser[0];
        String membership = ArrayUser[1];
        int point = Integer.parseInt(ArrayUser[2]);
        new menu(name, membership, point);
    }
}
