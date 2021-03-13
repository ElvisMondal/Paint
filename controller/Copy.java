package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;

public class Copy implements CommandInterface {
    IApplicationState appState;
    ShapeSubjectList shapeList;
    ShapeConfiguration shapeConfiguration;

    public Copy(IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void execute() {
        for (DrawShapeInterface shape : shapeList.getSelectedsShapesLists()) {
            shapeList.addsShapesToClipboards(shape);
        }
        System.out.println("Shapes Copied: "+shapeList.getsClipBoardsShapes().size());
    }
}
