package model;


//import javafx.scene.shape.Ellipse;

import view.gui.DrawRectangle;
import view.interfaces.DrawShapeInterface;


public class ShapeFactory {

    public DrawShapeInterface createShape(ShapeConfiguration shapeConfiguration) {
        ShapeType shapeType = shapeConfiguration.getShapeType();
        DrawShapeInterface shape = null;

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            System.out.println("ShapeCreateCommand executed. Rectangle drawn.");
            shape = new DrawRectangle(shapeConfiguration);
        } else if (shapeType.equals(ShapeType.ELLIPSE)) {
            System.out.println("ShapeCreateCommand executed. Ellipse drawn.");
            //shape = new Ellipse_DrawShape(shapeConfiguration);
        } else if (shapeType.equals(ShapeType.TRIANGLE)) {
            System.out.println("ShapeCreateCommand executed. Triangle drawn.");
            //shape = new Triangle_DrawShape(shapeConfiguration);
        } else {
            // System.out.println("this is NULLLLLLLL");
        }
        return shape;
    }
}
