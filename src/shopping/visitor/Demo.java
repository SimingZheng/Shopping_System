package shopping.visitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        computerPart computer = new computer();
        computer.accept(new computerPartDisplayVisitor());
    }
}
