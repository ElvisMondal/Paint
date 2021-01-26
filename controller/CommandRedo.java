package controller;

public class CommandRedo implements CommandInterface {
    @Override
    public void execute() {
        System.out.println("Command Executed => Redo");
        CommandHistory.redo();
    }
}
