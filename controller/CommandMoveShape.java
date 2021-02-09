package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class CommandMoveShape implements CommandInterface, IUndoable {
    private IApplicationState appState;
    private ShapeListSubjectInterface shapeList;
    private DrawShapeInterface old_shape;
    private DrawShapeInterface new_shape;
    private ArrayList<DrawShapeInterface> temporaryShapeList;


    public CommandMoveShape(IApplicationState applicationState, ShapeListSubjectInterface shapeList) {
        this.appState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {

        temporaryShapeList = new ArrayList<DrawShapeInterface>();

        int dx = appState.getEndPoint().getX() - appState.getStartPoint().getX();
        int dy = appState.getEndPoint().getY() - appState.getStartPoint().getY();

        for (DrawShapeInterface selectedShape : shapeList.get_SelectedShapesList()) {
            old_shape = selectedShape;
            temporaryShapeList.add(old_shape);
            shapeList.remove_Shape(old_shape);

            for (DrawShapeInterface tempShape : temporaryShapeList) {
                tempShape.addX(dx);
                tempShape.addY(dy);
                new_shape = tempShape;
                shapeList.add_Shape(new_shape);
            }
            temporaryShapeList.clear();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.remove_Shape(new_shape);
        shapeList.add_Shape(old_shape);
    }

    @Override
    public void redo() {
        shapeList.add_Shape(new_shape);
        shapeList.remove_Shape(old_shape);
    }
}

