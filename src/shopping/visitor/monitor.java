package shopping.visitor;

public class monitor  implements computerPart {

    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
