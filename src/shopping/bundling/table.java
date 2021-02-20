package shopping.bundling;
// Create entity classes that extend mainItemAbstract.
public class table extends mainItemAbstract{
    @Override
    public float price() {
        return 60;
    }

    @Override
    public String name() {
        return "table";
    }
}
