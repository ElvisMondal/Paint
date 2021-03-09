package controller;

import model.ShapeConfiguration;
import model.ShapeFactory;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeListSubjectInterface;
import view.gui.*;
import view.interfaces.DrawShapeInterface;

import java.awt.*;

public class CommandSelectShape implements CommandInterface {

    ShapeFactory shapeFactory = new ShapeFactory();
    private ShapeListSubjectInterface shapeList;
    private DrawShapeInterface selectedShape;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface shapes,sp;
    Boolean containsSelectedShape = false;

    public CommandSelectShape(IApplicationState applicationState, ShapeListSubjectInterface shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {

        //DrawShapeInterface shapeses = null;
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
               /*ShapeType shapeType = shapeConfiguration.getShapeType();
               if (shapeType.equals(ShapeType.RECTANGLE)) {
                   shapes= new DottedRect(shapeConfiguration,shape.getAdjustedStart().getX(),shape.getAdjustedStart().getY(),shape.getWidth(),shape.getHeight());
                   this.shapeList.add_Shape(shapes);
               } else if (shapeType.equals(ShapeType.ELLIPSE)) {
                   shapes= new DottedEllipse(shapeConfiguration,shape.getAdjustedStart().getX(),shape.getAdjustedStart().getY(),shape.getWidth(),shape.getHeight());
                   this.shapeList.add_Shape(shapes);
               } else if (shapeType.equals(ShapeType.TRIANGLE)) {
                   shapes= new DottedTriangle(shapeConfiguration,shape.getAdjustedStart().getX(),shape.getAdjustedStart().getY(),shape.getAdjustedEnd().getX(),shape.getAdjustedEnd().getY());
                   this.shapeList.add_Shape(shapes);
               } else {

               }*/

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

    public boolean containsSelectedShape(){ return containsSelectedShape;}

    public DrawShapeInterface getSelectedShape() {
        return selectedShape;
    }


}
