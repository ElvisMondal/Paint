package model;


import view.gui.DrawRectangle;
import view.interfaces.DrawShapeInterface;


public class ShapeFactory {

    public DrawShapeInterface createShape(ShapeConfiguration shapeConfiguration) {
        ShapeType shapeType = shapeConfiguration.getShapeType();
        DrawShapeInterface shape = null;

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            System.out.println("ShapeCreateCommand executed. Rectangle drawn.");
            shape = new DrawRectangle(shapeConfiguration);
        }
        return shape;
    }
}
