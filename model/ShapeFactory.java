package model;


import controller.NullPattern;
import view.gui.DrawEllipse;
import view.gui.DrawRectangle;
import view.gui.DrawTriangle;
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
            shape = new DrawEllipse(shapeConfiguration);
        } else if (shapeType.equals(ShapeType.TRIANGLE)) {
            System.out.println("ShapeCreateCommand executed. Triangle drawn.");
            shape = new DrawTriangle(shapeConfiguration);
        } else {
            // System.out.println("this is NULLLLLLLL");
            shape=new NullPattern();
        }
        return shape;
    }
}
