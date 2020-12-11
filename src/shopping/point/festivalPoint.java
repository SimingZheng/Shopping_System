package shopping.point;

import shopping.mall.userInitial;

// Create an entity decoration class that extends the points class
public class festivalPoint extends points {

    private int current_point;
    private String name;

    public festivalPoint(points user, int current_point, String name) {
        super(user);
        this.current_point = current_point;
        this.name = name;
    }

    @Override
    public void addPoint() {
        System.out.println("you earn extra point: " + current_point);
        userInitial ud = new userInitial();
        ud.setUserMap(name, current_point*2);
        super.addPoint();
    }
}