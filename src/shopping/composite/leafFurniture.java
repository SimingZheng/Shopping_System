package shopping.composite;

public class leafFurniture implements notification {
    private float price;
    private String name;

    public leafFurniture(float price, String name) {
        this.name = name;
        this.price = price;
    }

    public void printProduct() {
        System.out.println("You order bundling: " + name + " total cost " + price);
    }
}
