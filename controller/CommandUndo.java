package controller;

public class CommandUndo implements CommandInterface {

    @Override
    public void execute() {
        System.out.println("Command Executed => Undo");
        CommandHistory.undo();
    }
}
