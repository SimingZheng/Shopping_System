package shopping.visitor;

// Define an interface that represents the element
public interface computerPart {
    public void accept(computerPartVisitor computerPartVisitor);
}
