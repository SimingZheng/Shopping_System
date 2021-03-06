package shopping.composite;

import java.util.ArrayList;
import java.util.List;

public class compositeOperating implements notification {
    private float price;
    private String name;
    private List<notification> leaf = new ArrayList<notification>();

    public compositeOperating(float price, String name) {
        this.price = price;
        this.name = name;
    }

    public void printProduct() {
        leaf.forEach(notification::printProduct);
    }

    public void addProduct(notification product) {
        leaf.add(product);
    }

    public void removeProduct(notification product) {
        leaf.remove(product);
    }
}
