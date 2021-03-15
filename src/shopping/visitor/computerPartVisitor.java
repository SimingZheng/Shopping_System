package shopping.visitor;

public interface computerPartVisitor {
    public void visit(computerPart computer);
    public void visit(mouse mouse);
    public void visit(keyboard keyboard);
    public void visit(monitor monitor);
}