package shopping.visitor;

// Create an entity class that extends the computerPart class
public class keyboard implements computerPart {

    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
