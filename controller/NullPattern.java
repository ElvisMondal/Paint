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
    public Points getStartsPoints() {
        return null;
    }

    @Override
    public Points getEndsPoints() {
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
    public void setAdjustedsEnds(Points adjustedEnd) {
        System.out.println("No End-Coordinates for Null Shape  ");
    }

    @Override
    public void setAdjustedsStarts(Points adjustedStart) {
        System.out.println("No Start-Coordinates for Null Shape  ");
    }

    @Override
    public Points getAdjustedsStarts() {
        return null;
    }

    @Override
    public Points getAdjustedsEnds() {
        return null;
    }

    @Override
    public ShapeConfiguration getShapesConf() {
        return null;
    }

    @Override
    public int getWidths() {
        return 0;
    }

    @Override
    public int getHeights() {
        return 0;
    }


}
