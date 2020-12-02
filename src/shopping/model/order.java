package shopping.model;

import java.util.ArrayList;


public class order {
    ArrayList<product> list=new ArrayList<product>();

    double total;
    public order(ArrayList<product> orderlist, double total, String membership) {
        this.list=orderlist;
        switch (membership) {
            case "VIP":
                total *= 0.75;
                break;
            case "Gold":
                total *= 0.9;
                break;
            case "Supreme":
                total *= 0.8;
                break;
            default:
                total = total*1;
        }
        this.total=total;
    }

    public ArrayList<product> getList() {
        return list;
    }



    public void setList(ArrayList<product> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

}

