package view.gui;

import controller.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.dialogs.SingletonColor;
import view.interfaces.DrawShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawTriangle extends PaintCanvasBase implements DrawShapeInterface {

    private ShapeConfiguration shapeConfiguration;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private Graphics2D paint;
    private int width, height;
    private Points adjustedStart, adjustedEnd, startPoint;
    private int[] x = new int[3];
    private int[] y = new int[3];


    public DrawTriangle(ShapeConfiguration shapeConfiguration) {
        this.shapeConfiguration = shapeConfiguration;
        this.shapeShadingType = shapeConfiguration.getShadingType();
        this.primaryColor = SingletonColor.getColor(shapeConfiguration.getPrimaryColor());
        this.secondaryColor = SingletonColor.getColor(shapeConfiguration.getSecondaryColor());
        this.adjustedStart = shapeConfiguration.getAdjustedStart();
        this.adjustedEnd = shapeConfiguration.getAdjustedEnd();
        this.startPoint = shapeConfiguration.getStartPoint();
        this.x[0] = shapeConfiguration.getAdjustedStart().getX();
        this.x[1] = shapeConfiguration.getAdjustedEnd().getX();
        this.x[2] = shapeConfiguration.getAdjustedStart().getX();

        this.y[0] = shapeConfiguration.getAdjustedStart().getY();
        this.y[1] = shapeConfiguration.getAdjustedEnd().getY();
        this.y[2] = shapeConfiguration.getAdjustedEnd().getY();
    }


    public void draw(Graphics g) {

        paint=(Graphics2D) g;

        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            paint.setStroke(new BasicStroke(8));
            g.drawPolygon(x, y, 3);

        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(secondaryColor);
            g.fillPolygon(x, y, 3);

        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            paint.setStroke(new BasicStroke(8));
            g.drawPolygon(x, y, 3);
            g.setColor(secondaryColor);
            g.fillPolygon(x, y, 3);
        }
    }

    double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }


    boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {

        double A = area(x1, y1, x2, y2, x3, y3);
        double A1 = area(x, y, x2, y2, x3, y3);
        double A2 = area(x1, y1, x, y, x3, y3);
        double A3 = area(x1, y1, x2, y2, x, y);


        return (A == A1 + A2 + A3);
    }


    public boolean contains(Points startPoint) {
        if (isInside(x[0], y[0], x[1], y[1], x[2], y[2], startPoint.getX(), startPoint.getY())) {
            return true;
        } else {
            return false;
        }
    }

    public Points getStartsPoints() {
        return startPoint;
    }

    public Points getEndsPoints() {
        return adjustedEnd;
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
    public void addX(int dx) {
        this.x[0] = adjustedStart.getX() + dx;
        this.x[1] = adjustedEnd.getX() + dx;
        this.x[2] = adjustedStart.getX() + dx;
    }

    @Override
    public void addY(int dy) {
        this.y[0] = adjustedStart.getY() + dy;
        this.y[1] = adjustedEnd.getY() + dy;
        this.y[2] = adjustedEnd.getY() + dy;
    }

    public ShapeConfiguration getShapesConf() {
        return shapeConfiguration;
    }

    public int getWidths() {
        return width;
    }

    public int getHeights() {
        return height;
    }{
}

    @Override
    public Graphics2D getGraphics2D() {
        return paint;
    }


}
