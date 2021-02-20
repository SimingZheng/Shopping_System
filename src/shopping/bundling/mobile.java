package shopping.bundling;
// Create entity classes that extend mainItemAbstract.
public class mobile extends mainItemAbstract{
    @Override
    public float price() {
        return 90;
    }

    @Override
    public String name() {
        return "Nokia mobile";
    }
}
