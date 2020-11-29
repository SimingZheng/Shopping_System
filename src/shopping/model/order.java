package shopping.model;

import java.util.ArrayList;


public class order {
    ArrayList<product> list=new ArrayList<product>();

    double total;
    public order(ArrayList<product> orderlist, double total) {
        this.list=orderlist;
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

