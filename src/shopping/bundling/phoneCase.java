package shopping.bundling;
// Create entity classes that extend subItemAbstract.
public class phoneCase extends subItemAbstract{
    @Override
    public float price() {
        return 10;
    }

    @Override
    public String name() {
        return "phone case";
    }
}
