/*bridge*/
package shopping.mall;

interface Category {
    public String getCategory();
    public void setdiscountable(boolean b);
    public boolean getdiscountable();
}

class Household implements Category{
    private boolean discontable = true;
    private String category = "Household";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable = b;
    }

    @Override
    public boolean getdiscountable() {
        return discontable;
    }

}

class Furniture implements Category{
    private boolean discontable = true;
    private String category = "Furniture";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable =b;
    }
    @Override
    public boolean getdiscountable() {
        return discontable;
    }
}

class electronicProduct implements Category{
    private boolean discontable = true;
    private String category = "Electronic Product";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable =b;
    }
    @Override
    public boolean getdiscountable() {
        return discontable;
    }
}

class householdAppliances implements Category{
    private boolean discontable = true;
    private String category = "Household Appliances";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable =b;
    }
    @Override
    public boolean getdiscountable() {
        return discontable;
    }
}

class healthBeauty implements Category{
    private boolean discontable = true;
    private String category = "Health Beauty";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable =b;
    }
    @Override
    public boolean getdiscountable() {
        return discontable;
    }
}

class Clothes implements Category {
    private boolean discontable = true;
    private String category = "Clothes";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable =b;
    }
    @Override
    public boolean getdiscountable() {
        return discontable;
    }
}
class Bundling implements Category {
    private boolean discontable = true;
    private String category = "Bunding";

    public String getCategory(){
        return category;
    }

    @Override
    public void setdiscountable(boolean b) {
        discontable =b;
    }
    @Override
    public boolean getdiscountable() {
        return discontable;
    }
}
/*---------------------Brand----------------------*/

public abstract class product{
    String name = null;
    String id = null;
    double price = 0;
    int num = 0;
    public double discount_base = 1;
    Category category = null;
    public product(String name, String id, double price, int num, Category category) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.num = num;
        this.discount_base = 1;
        this.category = category;
    }

    public product() {

    }

    public abstract String getBrand();
    public abstract void setDiscount_base(double base);
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        if(category.getdiscountable() == false)
            return price;
        else
            return price * discount_base;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscount_base() {return discount_base;}
    public String getCategory(){return category.getCategory();}
}

class Fairy extends product {
    private double discount_base = 0.8;
    private String brand;

    public Fairy(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Fairy";
    }

    public Fairy() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount_base(double base) {
        discount_base = base;
    }
}

class Ikea extends product {

    private double discount_base = 0.9;
    private String brand;

    public Ikea(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Ikea";
    }

    public Ikea() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount_base(double base) {
        discount_base = base;
    }
}

class Sony extends product {

    private double discount = 1;
    private String brand;

    public Sony(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Sony";
    }

    public Sony() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount_base(double base) {
        discount_base = base;
    }
}
class Chanel extends product {

    private double discount_base = 1;
    private String brand;

    public Chanel(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Chanel";
    }

    public Chanel() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount_base(double base) {
        discount_base = base;
    }
}
class Apple extends product {

    private double discount_base = 1;
    private String brand;

    public Apple(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Apple";
    }

    public Apple() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    public void setDiscount_base(double base) {
        discount_base = base;
    }
}
class Philips extends product {

    private double discount_base = 0.9;
    private String brand;

    public Philips(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Philips";
    }

    public Philips() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    public void setDiscount_base(double base) {
        discount_base = base;
    }
}
class Zwilling extends product {

    private double discount_base = 0.9;
    private String brand;

    public Zwilling(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "Zwilling";
    }

    public Zwilling() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount_base(double base) {
        discount_base = base;
    }
}
class noBrand extends product {

    private double discount_base = 0.9;
    private String brand;

    public noBrand(String name, String id, double price, int num, Category category) {
        super(name, id, price, num, category);
        brand = "noBrand";
    }

    public noBrand() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void setDiscount_base(double base) {
        discount_base = base;
    }
}