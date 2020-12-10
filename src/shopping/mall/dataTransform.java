package shopping.mall;

import java.util.ArrayList;
import java.util.Vector;

public class dataTransform {
    product pro;

    public product getPro() {
        return pro;
    }

    public void setPro(product pro) {
        this.pro = pro;
    }

    public product productTransform(Vector<Object> v) {//Convert a single row of table information into a product information
        String id = (String) v.get(0);
        String name = (String) v.get(1);
        double price = Double.parseDouble(v.get(2).toString());
        int num = Integer.parseInt(v.get(3).toString());
        pro=new product(id, name, price, num);
        return pro;
    }

    public static void changeList(ArrayList<product> prolist, Vector<Vector<Object>> date) //Convert product information from ArrayList to Vector for table display
    {
        // TODO Auto-generated method stub
        for(product e : prolist){
            Vector<Object> row=new Vector<Object>();
            row.add(e.getId());
            row.add(e.getName());
            row.add(e.getPrice());
            date.add(row);
        }
    }
}
