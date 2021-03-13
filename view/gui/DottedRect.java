package view.gui;

import controller.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.SingletonColor;
import view.interfaces.DrawShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DottedRect extends PaintCanvasBase implements DrawShapeInterface {

    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private Graphics2D paint;
    private int width, height,widths,heights,AS,AE;
    private Points adjustedStart, adjustedEnd, startPoint, endPoint;
    private ShapeType shapeType;


    public DottedRect(ShapeConfiguration shapeConfiguration, int x, int y, int widths, int heights) {
        this.shapeConfig = shapeConfiguration;
        this.shapeShadingType=shapeConfiguration.getShadingType();
        this.primaryColor = SingletonColor.getColor(shapeConfiguration.getPrimaryColor());
        this.secondaryColor = SingletonColor.getColor(shapeConfiguration.getSecondaryColor());
        this.width = shapeConfiguration.getWidth();
        this.height = shapeConfiguration.getHeight();
        this.adjustedStart = shapeConfiguration.getAdjustedStart();
        this.adjustedEnd = shapeConfiguration.getAdjustedEnd();
        this.startPoint = shapeConfiguration.getStartPoint();
        this.shapeType = shapeConfiguration.getShapeType();
        this.endPoint = shapeConfiguration.getEndPoint();
        this.widths=widths;
        this.heights=heights;
        this.AS=x;
        this.AE=y;
    }

    @Override
    public void draw(Graphics g) {

        paint=(Graphics2D) g;
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        paint.setStroke(stroke);
        paint.setColor(Color.BLACK);
        paint.drawRect(AS-5, AE-5, widths+10, heights+10);
    }

    @Override
    public boolean contains(Points startPoint) {
        return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
                && adjustedStart.getX() + width > startPoint.getX() && adjustedStart.getY() + height > startPoint.getY());
    }

    @Override
    public int getWidths() {
        return width;
    }

    @Override
    public int getHeights() {
        return height;
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
    public void setAdjustedsStarts(Points adjustedStart) {
        this.adjustedStart = adjustedStart;
    }

    @Override
    public void setAdjustedsEnds(Points adjustedEnd) {
        this.adjustedEnd = adjustedEnd;
    }

    @Override
    public Points getAdjustedsStarts() {
        return adjustedStart;
    }

    @Override
    public Points getAdjustedsEnds() {
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
    public ShapeConfiguration getShapesConf() {
        return shapeConfig;
    }

    @Override
    public Graphics2D getGraphics2D() {
        return paint;
    }

}



