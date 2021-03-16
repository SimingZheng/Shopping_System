package shopping.visitor;

// Create an entity class that extends the computerPart class
public class monitor  implements computerPart {

    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
