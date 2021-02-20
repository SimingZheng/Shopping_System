package shopping.bundling;
//Create an abstract class that implements the bundlingItem interface, which provides default functions.
public abstract class subItemAbstract implements bundlingItem{
    @Override
    public bundling packing() {
        return new subItem();
    }

    @Override
    public abstract float price();
}
