package shopping.mall;

import java.util.ArrayList;

public class shoppingCart {

    private static double total = 0;// Total price of the shopping cart
    ArrayList<product> prolist = new ArrayList<product>();

    public ArrayList<product> getProlist() {
        return prolist;
    }

    public void setProlist(ArrayList<product> prolist) {
        this.prolist = prolist;
    }

    public static double getTotal() {
        return total;
    }

    public static void setTotal(double total) {
        shoppingCart.total = total;
    }

    public int addProduct(product pro) {// add item
        int i = 0;
        for (product e : prolist) {
            if (e.getId().equals(pro.getId())) {
                int n = e.getNum() + pro.getNum();
                e.setNum(n);
                return i;
            }
            i++;
        }
        prolist.add(pro);
        total = pro.getPrice() *pro.getNum() + total;
        return -1;
    }
}
