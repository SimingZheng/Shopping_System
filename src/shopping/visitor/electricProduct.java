package shopping.visitor;

public class electricProduct implements visitable{
    private double price;
    //accept the visitor
    public electricProduct(double price){
        this.price = price;
    }

    @Override
    public double accept(visitor visitor)   {
        return visitor.visit(this);
    }
    public double getPrice()   {
        return price;
    }
}
