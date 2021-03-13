package controller;

public class Redos implements CommandInterface {
    @Override
    public void execute() {
        System.out.println("Command Executed => Redo");
        CommandHistory.redo();
    }
}
