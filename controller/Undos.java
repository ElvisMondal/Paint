package controller;

public class Undos implements CommandInterface {

    @Override
    public void execute() {
        System.out.println("Command Executed => Undo");
        CommandHistory.undo();
    }
}
