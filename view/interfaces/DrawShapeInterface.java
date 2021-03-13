package view.interfaces;

import controller.Points;
import model.ShapeConfiguration;
import model.interfaces.IUndoable;


import java.awt.*;

public interface DrawShapeInterface{
    void draw(Graphics g);

    boolean contains(Points start_Point);

    Points getStartsPoints();

    Points getEndsPoints();

    void addX(int dx);

    void addY(int dy);

    void setAdjustedsEnds(Points adjustedEnd);

    void setAdjustedsStarts(Points adjustedStart);

    Points getAdjustedsStarts();

    Points getAdjustedsEnds();

    ShapeConfiguration getShapesConf();

    int getWidths();

    int getHeights();
}