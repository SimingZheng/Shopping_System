package shopping.visitor;

// Create an entity visitor that implements the computerPartVisitor class
public class computerPartDisplayVisitor implements computerPartVisitor {

    @Override
    public void visit(computerPart computer) {

    }

    @Override
    public void visit(mouse mouse) {
        System.out.println("Mouse 100€");
    }

    @Override
    public void visit(keyboard keyboard) {
        System.out.println("Keyboard 100€");
    }

    @Override
    public void visit(monitor monitor) {
        System.out.println("Monitor 100€");
    }

    @Override
    public void visit(computerHost computerHost) {
        System.out.println("Computer Host Host 200€");
    }
}