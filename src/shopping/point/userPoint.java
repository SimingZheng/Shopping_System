package shopping.point;

// Create entity classes that implement interfaces
public class userPoint implements pointSettor {

    private String name;

    public userPoint(String name) {
        this.name = name;
    }

    @Override
    public void addPoint() {
        System.out.println(name + " earned point");
    }
}
