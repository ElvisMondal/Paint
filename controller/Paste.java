package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class Paste  implements CommandInterface, IUndoable {
    private ShapeListSubjectInterface shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface newShape;
    private final ArrayList<DrawShapeInterface> tempShapeList = new ArrayList<DrawShapeInterface>();


    public Paste(IApplicationState applicationState, ShapeListSubjectInterface shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        for (DrawShapeInterface selectedShape : shapeList.get_SelectedShapesList()) {
            newShape = selectedShape;
            selectedShape.addX(50);
            selectedShape.addY(50);

            CommandCreateShape shape = new CommandCreateShape(appState, shapeList, selectedShape.getShapeConfiguration());
            tempShapeList.add(shape.shapeFactory.createShape(selectedShape.getShapeConfiguration()));
        }

        for (DrawShapeInterface selectedShape : tempShapeList) {
            shapeList.add_Shape(selectedShape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.remove_Shape(newShape);
    }

    @Override
    public void redo() {
        shapeList.add_Shape(newShape);
    }
}
