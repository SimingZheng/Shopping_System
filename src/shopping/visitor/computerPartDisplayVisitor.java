package shopping.visitor;

public class computerPartDisplayVisitor implements computerPartVisitor {

    @Override
    public void visit(computerPart computer) {

    }

    @Override
    public void visit(mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}