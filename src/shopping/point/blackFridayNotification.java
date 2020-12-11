package shopping.point;

import javax.swing.*;

public class blackFridayNotification {
    private static blackFridayNotification instance = new blackFridayNotification();

    private blackFridayNotification(){}

    public static blackFridayNotification getInstance(){
        return instance;
    }

    public void showNotification(){
        JOptionPane.showMessageDialog(null, " Happy Black Friday！", "remind", JOptionPane.WARNING_MESSAGE);
    }
}
