package controller;

import model.ShapeConfiguration;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.ShapeSubjectList;
import view.gui.DottedEllipse;
import view.gui.DottedRect;
import view.gui.DottedTriangle;
import view.interfaces.DrawShapeInterface;

public class OutlineClass implements IOutline {


    private ShapeConfiguration shapeConfiguration;
    private IApplicationState applicationState;
    private DrawShapeInterface shapess;
    private ShapeSubjectList shapeList;

    public OutlineClass(IApplicationState applicationState, ShapeSubjectList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void outline() {
        shapeConfiguration = applicationState.getCurrentShapeConfigs();

        ShapeType shapeType = shapeConfiguration.getShapeType();
        for (DrawShapeInterface shape : shapeList.getSelectedsShapesLists()) {
            if (shapeType.equals(ShapeType.RECTANGLE)) {
                shapess = new DottedRect(shapeConfiguration, shape.getAdjustedsStarts().getX(), shape.getAdjustedsStarts().getY(), shape.getWidths(), shape.getHeights());
                this.shapeList.addShap(shapess);
            } else if (shapeType.equals(ShapeType.ELLIPSE)) {
                shapess = new DottedEllipse(shapeConfiguration, shape.getAdjustedsStarts().getX(), shape.getAdjustedsStarts().getY(), shape.getWidths(), shape.getHeights());
                this.shapeList.addShap(shapess);
            } else if (shapeType.equals(ShapeType.TRIANGLE)) {
                shapess = new DottedTriangle(shapeConfiguration, shape.getAdjustedsStarts().getX(), shape.getAdjustedsStarts().getY(), shape.getAdjustedsEnds().getX(), shape.getAdjustedsEnds().getY());
                this.shapeList.addShap(shapess);
            } else {

            }

        }
    }



}
