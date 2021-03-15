package shopping.bundling;
//Create a bundleBuilder class, and the actual builder class is responsible for creating bundleProduct objects.
public class bundleBuilder {
    public bundleProduct prepareFurniture (){
        bundleProduct bundle = new bundleProduct();
        bundle.addItem(new table());
        bundle.addItem(new chair());
        return bundle;
    }

    public bundleProduct prepareElectricalProduct (){
        bundleProduct bundle = new bundleProduct();
        bundle.addItem(new mobile());
        bundle.addItem(new phoneCase());
        return bundle;
    }
}
