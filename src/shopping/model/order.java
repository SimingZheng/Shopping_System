package shopping.model;

import shopping.Interface.menu;

import java.util.ArrayList;


public class order {
    ArrayList<product> list=new ArrayList<product>();

    double total;
    String discount;
    int current_point;
    int discountPoint;
    String deliverFee;
    public order(ArrayList<product> orderlist, String name, double total, String membership, int point) {
        this.list=orderlist;
        switch (membership) {
            case "VIP":
                total *= 0.75;
                discount = " (5% discount)";
                break;
            case "Gold":
                total *= 0.9;
                discount = " (10% discount)";
                break;
            case "Supreme":
                total *= 0.8;
                discount = " (20% discount)";
                break;
            default:
                total = total*1;
                discount = " (no discount)";
                break;
        }
        current_point = (int) (total / 50);
        userInitial ud = new userInitial();
        ud.setUserMap(name, current_point);
        discountPoint = point;
        total -= 5*point;
        if (total <= 0)
            total = 0;
        if (total >= 100)
            deliverFee = "Free";
        else{
            total += 5;
            deliverFee = "5";
        }
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
    public void setTotal(double total) {
        this.total = total;
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

