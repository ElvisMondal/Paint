package view.gui;

import controller.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.SingletonColor;
import view.interfaces.DrawShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DottedEllipse extends PaintCanvasBase implements DrawShapeInterface {

    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private Graphics2D paint;
    private int width, height,widths,heights,AS,AE;
    private Points adjustedStart, adjustedEnd, startPoint;
    private ShapeType shapeType;

    public DottedEllipse(ShapeConfiguration shapeConfiguration, int x, int y, int widths, int heights) {
        this.shapeConfig = shapeConfiguration;
        this.shapeShadingType = shapeConfiguration.getShadingType();
        this.primaryColor = SingletonColor.getColor(shapeConfiguration.getPrimaryColor());
        this.secondaryColor = SingletonColor.getColor(shapeConfiguration.getSecondaryColor());
        this.width = shapeConfiguration.getWidth();
        this.height = shapeConfiguration.getHeight();
        this.adjustedStart = shapeConfiguration.getAdjustedStart();
        this.startPoint = shapeConfiguration.getStartPoint();
        this.adjustedEnd = shapeConfiguration.getAdjustedEnd();
        this.shapeType = shapeConfiguration.getShapeType();
        this.widths=widths;
        this.heights=heights;
        this.AS=x;
        this.AE=y;
    }

    @Override
    public void draw(Graphics g) {

        paint=(Graphics2D) g;
        paint.setColor(Color.BLACK);
        paint.setStroke(new BasicStroke(8));
        paint.drawOval(AS-5, AE-5, widths+10, heights+10);
    }

    @Override
    public boolean contains(Points startPoint) {
        return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
                && adjustedStart.getX() + width > startPoint.getX() && adjustedStart.getY() + height > startPoint.getY());
    }

    @Override
    public void setAdjustedStart(Points adjustedStart) {
        this.adjustedStart = adjustedStart;
    }

    @Override
    public void setAdjustedEnd(Points adjustedEnd) {
        this.adjustedEnd = adjustedEnd;
    }

    public Points getAdjustedStart() {
        return adjustedStart;
    }

    @Override
    public Points getAdjustedEnd() {
        return adjustedEnd;
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
    public void addX(int dx) {
        adjustedStart.setX(adjustedStart.getX() + dx);
        adjustedEnd.setX(adjustedEnd.getX() + dx);

    }

    @Override
    public void addY(int dy) {
        adjustedStart.setY(adjustedStart.getY() + dy);
        adjustedEnd.setY(adjustedEnd.getY() + dy);
    }

    public ShapeConfiguration getShapeConfiguration() {
        return shapeConfig;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }{
    }

    @Override
    public Graphics2D getGraphics2D() {
        return paint;
    }
}



