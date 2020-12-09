package shopping.model;

import shopping.Interface.menu;

import java.util.ArrayList;


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
        Array_MembershipDiscount = Ini.getMememberhipDiscount(total, membership);
        total = Double.parseDouble(Array_MembershipDiscount[0]);
        discount = Array_MembershipDiscount[1];
        current_point = Ini.getCurrentPoint(total);
        userInitial ud = new userInitial();
        ud.setUserMap(name, current_point);
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

