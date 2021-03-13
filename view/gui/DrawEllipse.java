package view.gui;

import controller.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.SingletonColor;
import view.interfaces.DrawShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawEllipse extends PaintCanvasBase implements DrawShapeInterface {

    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private Graphics2D paint;
    private int width, height;
    private Points adjustedStart, adjustedEnd, startPoint;
    private ShapeType shapeType;

    public DrawEllipse(ShapeConfiguration shapeConfiguration) {
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
    }

    @Override
    public void draw(Graphics g) {

        paint=(Graphics2D) g;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            paint.setStroke(new BasicStroke(8));
            g.drawOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(secondaryColor);
            g.fillOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            paint.setStroke(new BasicStroke(8));
            g.drawOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
            g.setColor(secondaryColor);
            g.fillOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
        }
    }

    @Override
    public boolean contains(Points startPoint) {
        return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
                && adjustedStart.getX() + width > startPoint.getX() && adjustedStart.getY() + height > startPoint.getY());
    }

    @Override
    public void setAdjustedsStarts(Points adjustedStart) {
        this.adjustedStart = adjustedStart;
    }

    @Override
    public void setAdjustedsEnds(Points adjustedEnd) {
        this.adjustedEnd = adjustedEnd;
    }

    public Points getAdjustedsStarts() {
        return adjustedStart;
    }

    @Override
    public Points getAdjustedsEnds() {
        return adjustedEnd;
    }

    @Override
    public Points getStartsPoints() {
        return startPoint;
    }

    @Override
    public Points getEndsPoints() {
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

    public ShapeConfiguration getShapesConf() {
        return shapeConfig;
    }

    @Override
    public int getWidths() {
        return width;
    }

    @Override
    public int getHeights() {
        return height;
    }{
}

    @Override
    public Graphics2D getGraphics2D() {
        return paint;
    }

}


