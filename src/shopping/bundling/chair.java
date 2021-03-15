package shopping.bundling;

// Create entity classes that extend subItemAbstract.
public class chair extends subItemAbstract{
    @Override
    public float price() {
        return 10;
    }

    @Override
    public String name() {
        return "chair";
    }
}
