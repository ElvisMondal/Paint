package controller;

import model.ShapeConfiguration;
import model.ShapeFactory;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;
import view.gui.*;
import view.interfaces.DrawShapeInterface;

public class CommandSelectShape implements CommandInterface {

    ShapeFactory shapeFactory = new ShapeFactory();
    private ShapeSubjectList shapeList;
    private DrawShapeInterface selectedShape;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface shapes,sp;
    Boolean containsSelectedShape = false;

    public CommandSelectShape(IApplicationState applicationState, ShapeSubjectList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {

        //DrawShapeInterface shapeses = null;
        System.out.println("Select mode...");


        shapeConfiguration = applicationState.getCurrentShapeConfigs();
        shapes = new Rect(shapeConfiguration);
        this.shapeList.addShap(shapes);




       for (DrawShapeInterface shape : shapeList.getShapesLists()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
           if((shapes.getAdjustedsEnds().getX())<(shape.getAdjustedsEnds().getX())){
               shapeList.addSelectedsLists(shape);
           }
            else if((shapes.getAdjustedsEnds().getX())>(shape.getAdjustedsEnds().getX())){
               shapeList.addSelectedsLists(shape);
           }
            else if ((shapes.getAdjustedsEnds().getY())<(shape.getAdjustedsEnds().getY())){
               shapeList.addSelectedsLists(shape);
           }
            else if ((shapes.getAdjustedsEnds().getY())>(shape.getAdjustedsEnds().getY())){
               shapeList.addSelectedsLists(shape);
           }
            else if ((containsSelectedShape==false) && (shapes.getAdjustedsEnds()!=null)){
               shapeList.addSelectedsLists(shape);
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
            shapeList.selectedsShapeListsClears();
            shapeList.getsClipBoardsShapes().clear();
            System.out.println("Shape List cleared. Shapes selected: " + shapeList.getSelectedsShapesLists().size());
        }


    }

    public boolean containsSelectedShape(){ return containsSelectedShape;}

    public DrawShapeInterface getSelectedShape() {
        return selectedShape;
    }


}
