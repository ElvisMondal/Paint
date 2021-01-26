package model;

import controller.Points;
import view.interfaces.DrawShapeInterface;

public class ShapeConfiguration {

    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Points startPoint;
    private Points endPoint;
    private ShapeShadingType shadingType;
    private ShapeType shapeType;
    private DrawShapeInterface selectedShape;
    private Points adjustedStart;
    private Points adjustedEnd;
    private int width;
    private int height;

    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public void setStartPoint(Points startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Points endPoint) {
        this.endPoint = endPoint;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public Points getStartPoint() {
        return startPoint;
    }

    public Points getEndPoint() {
        return endPoint;
    }

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        Points adjustedStart = getAdjustedStart();
        Points adjustedEnd = getAdjustedEnd();
        return adjustedEnd.getX() - adjustedStart.getX();
    }

    public int getHeight() {
        Points adjustedStart = getAdjustedStart();
        Points adjustedEnd = getAdjustedEnd();
        return adjustedEnd.getY() - adjustedStart.getY();
    }

    public Points getAdjustedStart() {
        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        return new Points(startX, startY);
    }

    public Points getAdjustedEnd() {
        int endX = Math.max(startPoint.getX(), endPoint.getX());
        int endY = Math.max(startPoint.getY(), endPoint.getY());
        return new Points(endX, endY);
    }

    public void setAdjustedEnd(Points adjustedEnd) {
        this.adjustedEnd = adjustedEnd;
    }

    public void setAdjustedStart(Points adjustedStart) {
        this.adjustedStart = adjustedStart;
    }


    public void setSelectedShape(DrawShapeInterface shape) {
        this.selectedShape = shape;

    }

    public DrawShapeInterface getSelectedShape() {
        return selectedShape;
    }
}

