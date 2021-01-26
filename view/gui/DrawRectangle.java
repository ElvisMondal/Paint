package view.gui;

import controller.Points;
import model.*;
import model.ShapeConfiguration;
import model.ShapeType;
import view.interfaces.DrawShapeInterface;

import java.awt.*;

public class DrawRectangle implements DrawShapeInterface {

        private ShapeConfiguration shapeConfig;
        private ShapeShadingType shapeShadingType;
        private Color primaryColor, secondaryColor;
        private int width, height;
        private Points adjustedStart, adjustedEnd, startPoint, endPoint;
        private ShapeType shapeType;


    public DrawRectangle(ShapeConfiguration shapeConfiguration) {
            this.shapeConfig = shapeConfiguration;
            this.shapeShadingType=shapeConfiguration.getShadingType();
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
            Graphics2D g2 = (Graphics2D) g;

            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(8));
            g.fillRect(adjustedStart.getX(), adjustedStart.getY(), width, height);

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


