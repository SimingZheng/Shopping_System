package shopping.visitor;

public class bundleDiscountVisitor implements visitor{
    private double furnitureBundlingCost;
    private double electricProductBundlingCost;

    //collect data about the book
    @Override
    public double visit(furniture furniture){
        furnitureBundlingCost += furniture.getPrice() * 0.8;
        return furnitureBundlingCost;
    }
    //add other visitors here
    @Override
    public double visit(electricProduct electricProduct){
        electricProductBundlingCost += electricProduct.getPrice() * 0.9;
        return electricProductBundlingCost;
    }
}
