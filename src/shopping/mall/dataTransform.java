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
        String category = (String) v.get(1);
        String brand = (String) v.get(2);
        String name = (String) v.get(3);
        double price = Double.parseDouble(v.get(4).toString());
        int num = Integer.parseInt(v.get(5).toString());
        switch (brand) {
            case "Fairy": switch (category) {
                case "Household":
                    pro = new Fairy(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Fairy(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Fairy(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Fairy(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Fairy(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Fairy(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Ikea":switch (category) {
                case "Household":
                    pro = new Ikea(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Ikea(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Ikea(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Ikea(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Ikea(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Ikea(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Sony":switch (category) {
                case "Household":
                    pro = new Sony(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Sony(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Sony(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Sony(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Sony(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Sony(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Chanel":switch (category) {
                case "Household":
                    pro = new Chanel(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Chanel(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Chanel(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Chanel(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Chanel(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Chanel(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Apple":switch (category) {
                case "Household":
                    pro = new Apple(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Apple(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Apple(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Apple(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Apple(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Apple(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Philips":switch (category) {
                case "Household":
                    pro = new Philips(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Philips(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Philips(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Philips(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Philips(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Philips(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Zwilling":switch (category) {
                case "Household":
                    pro = new Zwilling(name, id, price, -1, new Household());
                    break;
                case "Furniture":
                    pro = new Zwilling(name, id, price, -1, new Furniture());
                    break;
                case "Electronic Product":
                    pro = new Zwilling(name, id, price, -1, new electronicProduct());
                    break;
                case "Household appliances/electronics":
                    pro = new Zwilling(name, id, price, -1, new householdAppliances());
                    break;
                case "Health and Beauty":
                    pro = new Zwilling(name, id, price, -1, new healthBeauty());
                    break;
                case "Clothes":
                    pro = new Zwilling(name, id, price, -1, new Clothes());
                    break;
            } break;
            case "Bundling" : pro = new noBrand(name, id, price, -1, new Bundling()); break;
        }
        return pro;
    }

    public static void changeList(ArrayList<product> prolist, Vector<Vector<Object>> date) //Convert product information from ArrayList to Vector for table display
    {
        // TODO Auto-generated method stub
        for(product e : prolist){
            Vector<Object> row=new Vector<Object>();
            if(e != null){
                row.add(e.getId());
                row.add(e.getCategory());
                row.add(e.getBrand());
                row.add(e.getName());
                row.add(e.getPrice());
                date.add(row);
            }
        }
    }
}
