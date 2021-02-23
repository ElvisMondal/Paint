package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class Delete  implements CommandInterface, IUndoable {
    private ShapeListSubjectInterface shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    ArrayList<DrawShapeInterface> selectedShapes;

    public Delete(IApplicationState applicationState, ShapeListSubjectInterface shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        selectedShapes = shapeList.get_SelectedShapesList();
        for (DrawShapeInterface shape : selectedShapes) {
            shapeList.remove_Shape(shape);
            shapeList.observerNotification();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (DrawShapeInterface shape : selectedShapes) {
            shapeList.add_Shape(shape);
        }
    }

    @Override
    public void redo() {
        for (DrawShapeInterface shape : selectedShapes) {
            shapeList.remove_Shape(shape);
        }
    }
}
