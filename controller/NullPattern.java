package controller;

import model.ShapeConfiguration;
import view.interfaces.DrawShapeInterface;

import java.awt.*;

public class NullPattern implements DrawShapeInterface {
    @Override
    public void draw(Graphics g) {
        System.out.println("Cannot execute Null Shape");
    }

    @Override
    public boolean contains(Points start_Point) {
        return false;
    }

    @Override
    public Points getStartPoint() {
        return null;
    }

    @Override
    public Points getEndPoint() {
        return null;
    }

    @Override
    public void addX(int dx) {
        System.out.println("No X-Coordinates for Null Shape  ");
    }

    @Override
    public void addY(int dy) {
        System.out.println("No Y-Coordinates for Null Shape  ");
    }

    @Override
    public void setAdjustedEnd(Points adjustedEnd) {
        System.out.println("No End-Coordinates for Null Shape  ");
    }

    @Override
    public void setAdjustedStart(Points adjustedStart) {
        System.out.println("No Start-Coordinates for Null Shape  ");
    }

    @Override
    public Points getAdjustedStart() {
        return null;
    }

    @Override
    public Points getAdjustedEnd() {
        return null;
    }

    @Override
    public ShapeConfiguration getShapeConfiguration() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }


}
