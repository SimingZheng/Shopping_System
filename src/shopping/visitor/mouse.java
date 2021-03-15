package shopping.visitor;

public class mouse  implements computerPart {

    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}