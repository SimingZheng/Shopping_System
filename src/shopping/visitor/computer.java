package shopping.visitor;

// Create an entity class that extends the computerPart class
public class computer implements computerPart {

    computerPart[] parts;

    public computer(){
        parts = new computerPart[] {new mouse(), new keyboard(), new monitor(), new computerHost()};
    }

    @Override
    public void accept(computerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}