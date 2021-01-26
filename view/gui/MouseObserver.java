package view.gui;

import model.MouseMode;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.MouseAdapterObserverInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MouseObserver extends JFrame implements MouseAdapterObserverInterface {
    private IApplicationState applicationState;
    private PaintCanvas paintCanvas;
    private ShapeListSubjectInterface shapeList;
    private ShapeConfiguration shapeConfiguration;

    public MouseObserver(IApplicationState applicationState, PaintCanvas paintCanvas, ShapeListSubjectInterface shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
        applicationState.observerRegister(this);
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
            paintCanvas.addMouseListener(new MouseDrawer(applicationState, shapeList, shapeConfiguration));
        }

    }
}
