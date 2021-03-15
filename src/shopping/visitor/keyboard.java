package shopping.visitor;

public class keyboard implements computerPart {

    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
