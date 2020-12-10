package shopping.point;

import shopping.mall.userInitial;

public class normalPoint extends points {

    private int current_point;
    private String name;

    public normalPoint(points user, int current_point, String name) {
        super(user);
        this.current_point = current_point;
        this.name = name;
    }

    @Override
    public void addPoint() {
        System.out.println("earn normal point: " + current_point);
        userInitial ud = new userInitial();
        ud.setUserMap(name, current_point);
        super.addPoint();
    }
}