package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;

public class Copy implements CommandInterface {
    IApplicationState appState;
    ShapeListSubjectInterface shapeList;
    ShapeConfiguration shapeConfiguration;

    public Copy(IApplicationState applicationState, ShapeListSubjectInterface shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void execute() {
        for (DrawShapeInterface shape : shapeList.get_SelectedShapesList()) {
            shapeList.add_ShapesToClipboard(shape);
        }
        System.out.println("Shapes Copied: "+shapeList.get_ClipBoardShapes().size());
    }
}
