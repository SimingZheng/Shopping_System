package shopping.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class mall {
    ArrayList<product> prolist=new ArrayList<product>();

    public ArrayList<product> getProlist() {
        return prolist;
    }

    public void setProlist(ArrayList<product> prolist) {
        this.prolist = prolist;
    }


    public ArrayList<product> searchProduct(String pro) {//search product
        ArrayList<product> list=new ArrayList<product>();
        for(product a: prolist) {
            if(a.getName().indexOf(pro)!=-1) {
                list.add(a);
            }
        }
        return list;
    }


    public static void importMall1(ArrayList<product> prolist) {//load the product
        // TODO Auto-generated method stub
        BufferedReader br= null;
        try {
            br=new BufferedReader(new FileReader(new File("src/shopping/input.txt")));
            String line;
            try {
                while((line=br.readLine())!=null) {
                    String id;
                    String name;
                    double price;
                    String[] strs=line.split(",");
                    id=strs[0];name=strs[1];price=Double.parseDouble(strs[2]);
                    product p = new product(id,name,price,-1);
                    prolist.add(p);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//		Product p0 = new Product("1001","aaa",15.0,-1);prolist.add(p0);
//		Product p1 = new Product("1002","bbba",100.0,-1);prolist.add(p1);
//		Product p2 = new Product("1003","ccc",20.0,-1);prolist.add(p2);
//		Product p3 = new Product("1004","ddd",30.0,-1);prolist.add(p3);
//		Product p4 = new Product("1005","eaee",80.0,-1);prolist.add(p4);
//		Product p5 = new Product("1006","fff",60.0,-1);prolist.add(p5);
//		Product p6 = new Product("1007","ggg",40.0,-1);prolist.add(p6);
//		Product p7 = new Product("1008","hhh",60.0,-1);prolist.add(p7);
//		Product p8 = new Product("1009","www",14.0,-1);prolist.add(p8);
//		Product p9 = new Product("1010","ooo",12.0,-1);prolist.add(p9);
//		Product p10 = new Product("1011","ppp",70.0,-1);prolist.add(p10);
//
    }
}
