package view.gui;

import model.interfaces.ShapeObserverList;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;
//import view.interfaces.PaintCanvasBase;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas  extends JComponent implements ShapeObserverList {
    private final ShapeSubjectList shapelist;

    public PaintCanvas(ShapeSubjectList shapelist) {
        this.shapelist = shapelist;
        shapelist.subscribes(this);
    }

    @Override
    public void updateShapeLists() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (DrawShapeInterface shape : shapelist.getShapesLists()) {
            shape.draw(g);
        }
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
