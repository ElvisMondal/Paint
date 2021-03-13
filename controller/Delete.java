package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class Delete  implements CommandInterface, IUndoable {
    private ShapeSubjectList shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    ArrayList<DrawShapeInterface> selectedShapes;

    public Delete(IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        selectedShapes = shapeList.getSelectedsShapesLists();
        for (DrawShapeInterface shape : selectedShapes) {
            shapeList.removeShap(shape);
            shapeList.observersNotification();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (DrawShapeInterface shape : selectedShapes) {
            shapeList.addShap(shape);
        }
    }

    @Override
    public void redo() {
        for (DrawShapeInterface shape : selectedShapes) {
            shapeList.removeShap(shape);
        }
    }
}
