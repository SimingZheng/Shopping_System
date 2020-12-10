package shopping.mall;

import shopping.point.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class order {
    ArrayList<product> list=new ArrayList<product>();

    double total;
    String discount;
    String deliverFee;
    int current_point;
    int discountPoint;
    String [] Array_MembershipDiscount;
    String [] Array_DeliverFee;

    public order(ArrayList<product> orderlist, String name, double total, String membership, int point) {
        this.list=orderlist;

        userInitial Ini = new userInitial();
        Array_MembershipDiscount = Ini.getMemberhipDiscount(total, membership);
        total = Double.parseDouble(Array_MembershipDiscount[0]);
        discount = Array_MembershipDiscount[1];

        current_point = Ini.getCurrentPoint(total);
        pointSettor userPoint = new userPoint(name);
        points Points = new points(userPoint);
        SimpleDateFormat data_format = new SimpleDateFormat("MM-dd-yyyy");
        String BlackFriday = "11-27-2020";
        Date Today = new Date( );
        System.out.println(data_format.format(Today));
        if(BlackFriday.equals(data_format.format(Today))) {
            points festival_point = new festivalPoint(Points, current_point, name);
            festival_point.addPoint();
            current_point = current_point*2;
        }else {
            points normal_point = new normalPoint(Points, current_point, name);
            normal_point.addPoint();
        }

        discountPoint = point;
        total = Ini.getPointDiscount(total, point);

        Array_DeliverFee = Ini.getDeliverFee(total);
        total = Double.parseDouble(Array_DeliverFee[0]);
        deliverFee = Array_DeliverFee[1];
        this.total = total;
    }

    public ArrayList<product> getList() {
        return list;
    }
    public void setList(ArrayList<product> list) {
        this.list = list;
    }
    public String getDiscount(){
        return discount;
    }
    public double getTotal() {
        return total;
    }
    public int getCurrent_point(){
        return current_point;
    }
    public int getDiscountPoint(){
        return discountPoint;
    }
    public String getDeliverFee(){
        return deliverFee;
    }
}

