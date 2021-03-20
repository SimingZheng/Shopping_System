package shopping.visitor;

public interface visitor{
    public double visit(furniture book);
    //visit other concrete items
    public double visit(electricProduct cd);
}
