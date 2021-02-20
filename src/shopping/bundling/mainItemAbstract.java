package shopping.bundling;
//Create an abstract class that implements the bundlingItem interface, which provides default functions.
public abstract class mainItemAbstract implements bundlingItem{
    @Override
    public bundling packing() {
        return new mainItem();
    }

    @Override
    public abstract float price();
}
