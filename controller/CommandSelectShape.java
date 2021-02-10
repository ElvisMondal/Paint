package controller;

import model.ShapeConfiguration;
import model.ShapeFactory;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeListSubjectInterface;
import view.gui.DrawRectangle;
import view.gui.Rect;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class CommandSelectShape implements CommandInterface {

    ShapeFactory shapeFactory = new ShapeFactory();
    private ShapeListSubjectInterface shapeList;
    private DrawShapeInterface selectedShape;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface shapes;
    Boolean containsSelectedShape = false;

    public CommandSelectShape(IApplicationState applicationState, ShapeListSubjectInterface shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        System.out.println("Select mode...");

        shapeConfiguration = applicationState.get_CurrentShapeConfigs();
        shapes = new Rect(shapeConfiguration);
        this.shapeList.add_Shape(shapes);



       for (DrawShapeInterface shape : shapeList.get_ShapeList()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
           if((shapes.getAdjustedEnd().getX())<(shape.getAdjustedEnd().getX())){
               shapeList.add_SelectedList(shape);
           }
            else if((shapes.getAdjustedEnd().getX())>(shape.getAdjustedEnd().getX())){
               shapeList.add_SelectedList(shape);
           }
            else if ((shapes.getAdjustedEnd().getY())<(shape.getAdjustedEnd().getY())){
               shapeList.add_SelectedList(shape);
           }
            else if ((shapes.getAdjustedEnd().getY())>(shape.getAdjustedEnd().getY())){
               shapeList.add_SelectedList(shape);
           }
            else if ((containsSelectedShape==false) && (shapes.getAdjustedEnd()!=null)){
               shapeList.add_SelectedList(shape);
           }
            else {

           }

           if (contain){
               containsSelectedShape = true;
               selectedShape = shape;
               shapeList.add_SelectedList(selectedShape);
               System.out.println(">> Shape selected. ");
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
