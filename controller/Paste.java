package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class Paste  implements CommandInterface, IUndoable {
    private ShapeSubjectList shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface newShape;
    private final ArrayList<DrawShapeInterface> tempShapeList = new ArrayList<DrawShapeInterface>();


    public Paste(IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        for (DrawShapeInterface selectedShape : shapeList.getSelectedsShapesLists()) {
            newShape = selectedShape;
            selectedShape.addX(80);
            selectedShape.addY(80);

            CommandCreateShape shape = new CommandCreateShape(appState, shapeList, selectedShape.getShapesConf());
            tempShapeList.add(shape.shapeFactory.createShape(selectedShape.getShapesConf()));
        }

        for (DrawShapeInterface selectedShape : tempShapeList) {
            shapeList.addShap(selectedShape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShap(newShape);
    }

    @Override
    public void redo() {
        shapeList.addShap(newShape);
    }
}
