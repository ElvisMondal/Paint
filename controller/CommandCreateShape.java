package controller;

import model.interfaces.IUndoable;
import model.ShapeConfiguration;
import model.ShapeFactory;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;
import model.interfaces.IApplicationState;

public class CommandCreateShape implements CommandInterface, IUndoable {

    ShapeFactory shapeFactory = new ShapeFactory();
    private final IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private ShapeSubjectList shapeList;
    private DrawShapeInterface shape;

    public CommandCreateShape(IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void execute() {
        shapeConfiguration = applicationState.getCurrentShapeConfi();
        shape = shapeFactory.createShape(shapeConfiguration);
        this.shapeList.addShap(shape);
        CommandHistory.add(this);
    }

    public DrawShapeInterface getShape() {
        return shape;
    }

    @Override
    public void undo() {
        shapeList.removeShap(shape);
    }

    @Override
    public void redo() {
        shapeList.addShap(shape);
    }


}

