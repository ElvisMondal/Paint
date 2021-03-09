package controller;

import model.ShapeConfiguration;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.ShapeListSubjectInterface;
import view.gui.DottedEllipse;
import view.gui.DottedRect;
import view.gui.DottedTriangle;
import view.gui.Rect;
import view.interfaces.DrawShapeInterface;

public class OutlineClass implements IOutline {


    private ShapeConfiguration shapeConfiguration;
    private IApplicationState applicationState;
    private DrawShapeInterface shapess;
    private ShapeListSubjectInterface shapeList;

    public OutlineClass(IApplicationState applicationState, ShapeListSubjectInterface shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void outline() {
        shapeConfiguration = applicationState.get_CurrentShapeConfigs();

        ShapeType shapeType = shapeConfiguration.getShapeType();
        for (DrawShapeInterface shape : shapeList.get_SelectedShapesList()) {
            if (shapeType.equals(ShapeType.RECTANGLE)) {
                shapess = new DottedRect(shapeConfiguration, shape.getAdjustedStart().getX(), shape.getAdjustedStart().getY(), shape.getWidth(), shape.getHeight());
                this.shapeList.add_Shape(shapess);
            } else if (shapeType.equals(ShapeType.ELLIPSE)) {
                shapess = new DottedEllipse(shapeConfiguration, shape.getAdjustedStart().getX(), shape.getAdjustedStart().getY(), shape.getWidth(), shape.getHeight());
                this.shapeList.add_Shape(shapess);
            } else if (shapeType.equals(ShapeType.TRIANGLE)) {
                shapess = new DottedTriangle(shapeConfiguration, shape.getAdjustedStart().getX(), shape.getAdjustedStart().getY(), shape.getAdjustedEnd().getX(), shape.getAdjustedEnd().getY());
                this.shapeList.add_Shape(shapess);
            } else {

            }

        }
    }



}
