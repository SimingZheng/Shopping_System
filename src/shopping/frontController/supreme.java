package shopping.frontController;

import shopping.mallBackend.menu;

public class supreme {
    private String [] ArrayUser = new String[3];
    public void generate() {
        ArrayUser[0] = "Supreme_user";
        ArrayUser[1] = "Supreme";
        ArrayUser[2] = "2";

        String name = ArrayUser[0];
        String membership = ArrayUser[1];
        int point = Integer.parseInt(ArrayUser[2]);
        new menu(name, membership, point);
    }
}
