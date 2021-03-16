package shopping.visitor;

public class computerHost implements computerPart {
    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
