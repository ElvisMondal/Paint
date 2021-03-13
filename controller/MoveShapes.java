package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class MoveShapes implements CommandInterface, IUndoable {
    private IApplicationState appState;
    private ShapeSubjectList shapeList;
    private DrawShapeInterface old_shape;
    private DrawShapeInterface new_shape;
    private ArrayList<DrawShapeInterface> temporaryShapeList;


    public MoveShapes(IApplicationState applicationState, ShapeSubjectList shapeList) {
        this.appState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {

        temporaryShapeList = new ArrayList<>();

        int dx = appState.getEndPoint().getX() - appState.getStartPoint().getX();
        int dy = appState.getEndPoint().getY() - appState.getStartPoint().getY();

        for (DrawShapeInterface selectedShape : shapeList.getSelectedsShapesLists()) {
            old_shape = selectedShape;
            temporaryShapeList.add(old_shape);
            shapeList.removeShap(old_shape);

            for (DrawShapeInterface tempShape : temporaryShapeList) {
                tempShape.addX(dx);
                tempShape.addY(dy);
                new_shape = tempShape;
                shapeList.addShap(new_shape);
            }
            temporaryShapeList.clear();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShap(new_shape);
        shapeList.addShap(old_shape);
    }

    @Override
    public void redo() {
        shapeList.addShap(new_shape);
        shapeList.removeShap(old_shape);
    }
}

