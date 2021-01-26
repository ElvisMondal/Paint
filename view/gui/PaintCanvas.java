package view.gui;

import model.interfaces.ShapeListObserverInterface;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;
//import view.interfaces.PaintCanvasBase;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas  extends JComponent implements ShapeListObserverInterface {
    private final ShapeListSubjectInterface shapelist;

    public PaintCanvas(ShapeListSubjectInterface shapelist) {
        this.shapelist = shapelist;
        shapelist.subscribe(this);
    }

    @Override
    public void updateShapeList() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (DrawShapeInterface shape : shapelist.get_ShapeList()) {
            shape.draw(g);
        }
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
