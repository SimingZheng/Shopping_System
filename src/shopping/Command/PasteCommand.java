package shopping.Command;


public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());

        //editor.jt1.getDocument().insertString(editor.jt1.getCaretPosition(), editor.clipboard, null);
        //editor.jt1.setText(editor.jt1.getText()+editor.clipboard, editor.jt1.getCaretPosition());
        return true;
    }
}