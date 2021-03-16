package shopping.visitor;

// Define an interface that represents the visitor
public interface computerPartVisitor {
    public void visit(computerPart computer);
    public void visit(mouse mouse);
    public void visit(keyboard keyboard);
    public void visit(monitor monitor);
    public void visit(computerHost computerHost);
}