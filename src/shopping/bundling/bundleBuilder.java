package shopping.bundling;
//Create a bundleBuilder class, and the actual builder class is responsible for creating bundleProduct objects.
public class bundleBuilder {
    public bundleProduct prepareFurniture (){
        bundleProduct meal = new bundleProduct();
        meal.addItem(new table());
        meal.addItem(new chair());
        return meal;
    }

    public bundleProduct prepareMobile (){
        bundleProduct meal = new bundleProduct();
        meal.addItem(new mobile());
        meal.addItem(new phoneCase());
        return meal;
    }
}
