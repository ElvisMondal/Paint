package view.gui;


import controller.CommandMoveShape;
import controller.Points;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeListSubjectInterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseMover extends MouseAdapter {
    private Points startPoint;
    private Points endPoint;
    private IApplicationState applicationState;
    private ShapeListSubjectInterface shapeList;
    private ShapeConfiguration shapeConfiguration;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public MouseMover(IApplicationState applicationState, ShapeListSubjectInterface shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Points(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        CommandMoveShape newMove = new CommandMoveShape(applicationState, shapeList);
        newMove.execute();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        applicationState.setStartPoint(startPoint);
    }
}

