package controller;

import model.interfaces.IApplicationState;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;

public class CommandSelectShape implements CommandInterface {

    private ShapeListSubjectInterface shapeList;
    private DrawShapeInterface selectedShape;
    private IApplicationState applicationState;
    Boolean containsSelectedShape = false;

    public CommandSelectShape(IApplicationState applicationState, ShapeListSubjectInterface shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        System.out.println("Select mode...");

        for (DrawShapeInterface shape : shapeList.get_ShapeList()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
            if (contain) {
                containsSelectedShape = true;
                selectedShape = shape;
                shapeList.add_SelectedList(selectedShape);
                System.out.println(">> Shape selected. " + shapeList.get_SelectedShapesList().size());
                break;
            } else {
                containsSelectedShape = false;
            }
        }
        if (containsSelectedShape == false) {
            shapeList.selectedShapeListClear();
            shapeList.get_ClipBoardShapes().clear();
            System.out.println("Shape List cleared. Shapes selected: " + shapeList.get_SelectedShapesList().size());
        }
    }

    public DrawShapeInterface getSelectedShape() {
        return selectedShape;
    }
}
