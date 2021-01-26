package controller;

import model.interfaces.IUndoable;
import model.ShapeConfiguration;
import model.ShapeFactory;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;
import model.interfaces.IApplicationState;

public class CommandCreateShape implements CommandInterface, IUndoable {

    ShapeFactory shapeFactory = new ShapeFactory();
    private final IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private ShapeListSubjectInterface shapeList;
    private DrawShapeInterface shape;

    public CommandCreateShape(IApplicationState applicationState, ShapeListSubjectInterface shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void execute() {
        shapeConfiguration = applicationState.get_CurrentShapeConfig();
        shape = shapeFactory.createShape(shapeConfiguration);
        this.shapeList.add_Shape(shape);
        CommandHistory.add(this);
    }

    public DrawShapeInterface getShape() {
        return shape;
    }

    @Override
    public void undo() {
        shapeList.remove_Shape(shape);
    }

    @Override
    public void redo() {
        shapeList.add_Shape(shape);
    }


}

