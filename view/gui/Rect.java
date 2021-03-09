package view.gui;

import controller.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.SingletonColor;
import view.interfaces.DrawShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Rect implements DrawShapeInterface {

    private ShapeConfiguration shapeConfig;
    private Graphics2D paint;
    private int width, height;
    private Points adjustedStart, adjustedEnd, startPoint, endPoint;
    private ShapeType shapeType;


    public Rect(ShapeConfiguration shapeConfiguration) {
        this.shapeConfig = shapeConfiguration;
        this.width = shapeConfiguration.getWidth();
        this.height = shapeConfiguration.getHeight();
        this.adjustedStart = shapeConfiguration.getAdjustedStart();
        this.adjustedEnd = shapeConfiguration.getAdjustedEnd();
        this.startPoint = shapeConfiguration.getStartPoint();
        this.shapeType = shapeConfiguration.getShapeType();
        this.endPoint = shapeConfiguration.getEndPoint();
    }

    @Override
    public void draw(Graphics g) {

            Color color=new Color(0,0,0,0.0f);
            g.setColor(color);
            g.drawRect(adjustedStart.getX(), adjustedStart.getY(), width, height);

    }

    @Override
    public boolean contains(Points startPoint) {
        return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
                && adjustedStart.getX() + width > startPoint.getX() && adjustedStart.getY() + height > startPoint.getY());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Points getStartPoint() {
        return startPoint;
    }

    @Override
    public Points getEndPoint() {
        return adjustedEnd;
    }

    @Override
    public void setAdjustedStart(Points adjustedStart) {
        this.adjustedStart = adjustedStart;
    }

    @Override
    public void setAdjustedEnd(Points adjustedEnd) {
        this.adjustedEnd = adjustedEnd;
    }

    @Override
    public Points getAdjustedStart() {
        return adjustedStart;
    }

    @Override
    public Points getAdjustedEnd() {
        return adjustedEnd;
    }

    @Override
    public void addX(int dx) {
        adjustedStart.setX(adjustedStart.getX() + dx);
        adjustedEnd.setX(adjustedEnd.getX() + dx);
    }

    @Override
    public void addY(int dy) {
        adjustedStart.setY(adjustedStart.getY() + dy);
        adjustedEnd.setY(adjustedEnd.getY() + dy);
    }


    @Override
    public ShapeConfiguration getShapeConfiguration() {
        return shapeConfig;
    }


}
