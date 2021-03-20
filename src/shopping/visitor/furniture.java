package shopping.visitor;

//concrete element
public class furniture implements visitable{
    private double price;
    //accept the visitor
    public furniture(double price){
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