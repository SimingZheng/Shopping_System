package shopping.mall;

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
            br=new BufferedReader(new FileReader(new File("src/shopping/database/productlist.txt")));
            String line;
            try {
                while((line=br.readLine())!=null) {
                    String id;
                    String name;
                    String category;
                    String brand;
                    double price;
                    String[] strs = line.split(",");
                    id = strs[0];
                    category = strs[1];
                    brand = strs[2];
                    name=strs[3];
                    price=Double.parseDouble(strs[4]);
                    product p = null;
                    switch (brand) {
                        case "Fairy": switch (category) {
                                case "Household":
                                    p = new Fairy(name, id, price, -1, new Household());
                                    break;
                                case "Furniture":
                                    p = new Fairy(name, id, price, -1, new Furniture());
                                    break;
                                case "Electronic Product":
                                    p = new Fairy(name, id, price, -1, new electronicProduct());
                                    break;
                                case "Household appliances/electronics":
                                    p = new Fairy(name, id, price, -1, new householdAppliances());
                                    break;
                                case "Health and Beauty":
                                    p = new Fairy(name, id, price, -1, new healthBeauty());
                                    break;
                                case "Clothes":
                                    p = new Fairy(name, id, price, -1, new Clothes());
                                    break;
                            } break;
                        case "Ikea":switch (category) {
                            case "Household":
                                p = new Ikea(name, id, price, -1, new Household());
                                break;
                            case "Furniture":
                                p = new Ikea(name, id, price, -1, new Furniture());
                                break;
                            case "Electronic Product":
                                p = new Ikea(name, id, price, -1, new electronicProduct());
                                break;
                            case "Household appliances/electronics":
                                p = new Ikea(name, id, price, -1, new householdAppliances());
                                break;
                            case "Health and Beauty":
                                p = new Ikea(name, id, price, -1, new healthBeauty());
                                break;
                            case "Clothes":
                                p = new Ikea(name, id, price, -1, new Clothes());
                                break;
                        } break;
                        case "Sony":switch (category) {
                            case "Household":
                                p = new Sony(name, id, price, -1, new Household());
                                break;
                            case "Furniture":
                                p = new Sony(name, id, price, -1, new Furniture());
                                break;
                            case "Electronic Product":
                                p = new Sony(name, id, price, -1, new electronicProduct());
                                break;
                            case "Household appliances/electronics":
                                p = new Sony(name, id, price, -1, new householdAppliances());
                                break;
                            case "Health and Beauty":
                                p = new Sony(name, id, price, -1, new healthBeauty());
                                break;
                            case "Clothes":
                                p = new Sony(name, id, price, -1, new Clothes());
                                break;
                        } break;
                        case "Chanel":switch (category) {
                            case "Household":
                                p = new Chanel(name, id, price, -1, new Household());
                                break;
                            case "Furniture":
                                p = new Chanel(name, id, price, -1, new Furniture());
                                break;
                            case "Electronic Product":
                                p = new Chanel(name, id, price, -1, new electronicProduct());
                                break;
                            case "Household appliances/electronics":
                                p = new Chanel(name, id, price, -1, new householdAppliances());
                                break;
                            case "Health and Beauty":
                                p = new Chanel(name, id, price, -1, new healthBeauty());
                                break;
                            case "Clothes":
                                p = new Chanel(name, id, price, -1, new Clothes());
                                break;
                        } break;
                        case "Apple":switch (category) {
                            case "Household":
                                p = new Apple(name, id, price, -1, new Household());
                                break;
                            case "Furniture":
                                p = new Apple(name, id, price, -1, new Furniture());
                                break;
                            case "Electronic Product":
                                p = new Apple(name, id, price, -1, new electronicProduct());
                                break;
                            case "Household appliances/electronics":
                                p = new Apple(name, id, price, -1, new householdAppliances());
                                break;
                            case "Health and Beauty":
                                p = new Apple(name, id, price, -1, new healthBeauty());
                                break;
                            case "Clothes":
                                p = new Apple(name, id, price, -1, new Clothes());
                                break;
                        } break;
                        case "Philips":switch (category) {
                            case "Household":
                                p = new Philips(name, id, price, -1, new Household());
                                break;
                            case "Furniture":
                                p = new Philips(name, id, price, -1, new Furniture());
                                break;
                            case "Electronic Product":
                                p = new Philips(name, id, price, -1, new electronicProduct());
                                break;
                            case "Household appliances/electronics":
                                p = new Philips(name, id, price, -1, new householdAppliances());
                                break;
                            case "Health and Beauty":
                                p = new Philips(name, id, price, -1, new healthBeauty());
                                break;
                            case "Clothes":
                                p = new Philips(name, id, price, -1, new Clothes());
                                break;
                        } break;
                        case "Zwilling":switch (category) {
                            case "Household":
                                p = new Zwilling(name, id, price, -1, new Household());
                                break;
                            case "Furniture":
                                p = new Zwilling(name, id, price, -1, new Furniture());
                                break;
                            case "Electronic Product":
                                p = new Zwilling(name, id, price, -1, new electronicProduct());
                                break;
                            case "Household appliances/electronics":
                                p = new Zwilling(name, id, price, -1, new householdAppliances());
                                break;
                            case "Health and Beauty":
                                p = new Zwilling(name, id, price, -1, new healthBeauty());
                                break;
                            case "Clothes":
                                p = new Zwilling(name, id, price, -1, new Clothes());
                                break;
                        } break;
                        case "Bundling" : p = new noBrand(name, id, price, -1, new Bundling()); break;
                    }
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
