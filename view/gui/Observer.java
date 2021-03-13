package view.gui;

import model.MouseMode;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;
import view.interfaces.MouseAdapterObserverInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Observer extends JFrame implements MouseAdapterObserverInterface {
    private IApplicationState applicationState;
    private PaintCanvas paintCanvas;
    private ShapeSubjectList shapeList;
    private ShapeConfiguration shapeConfiguration;



    public Observer(IApplicationState applicationState, PaintCanvas paintCanvas, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
        applicationState.observerRegisters(this);
    }

    public void execute() {

        MouseListener[] mouseListeners = paintCanvas.getMouseListeners();
        for (MouseListener mouseListener : mouseListeners) {
            paintCanvas.removeMouseListener(mouseListener);
        }

        MouseMode startAndEndPointMode = applicationState.getActiveMouseMode();

        if (startAndEndPointMode.equals(MouseMode.DRAW))
        {
            paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
            paintCanvas.addMouseListener(new Drawer(applicationState, shapeList, shapeConfiguration));
        }
        else if (startAndEndPointMode.equals(MouseMode.SELECT))
        {
            paintCanvas.setCursor((new Cursor(Cursor.HAND_CURSOR)));
            paintCanvas.addMouseListener(new Selector(applicationState, shapeList));

        }
        else if (startAndEndPointMode.equals(MouseMode.MOVE))
        {
            paintCanvas.setCursor((new Cursor(Cursor.MOVE_CURSOR)));
            paintCanvas.addMouseListener(new Mover(applicationState, shapeList, shapeConfiguration));
        }

    }
}
