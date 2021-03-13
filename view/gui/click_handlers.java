package view.gui;

import controller.CommandCreateShape;
import controller.MoveShapes;
import controller.CommandSelectShape;
import controller.Points;
import model.MouseMode;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class click_handlers extends MouseAdapter {
    private Points startPoint, endPoint;
    private IApplicationState appState;
    private ShapeSubjectList shapeList;
    private ShapeConfiguration shapeConfig;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public click_handlers(IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfiguration;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (appState.getActiveStartAndEndPointMode() == MouseMode.DRAW) {

            ShapeColor primaryColor = appState.getActivePrimaryColor();
            shapecolor.add(primaryColor);
            ShapeColor secondaryColor = appState.getActiveSecondaryColor();
            shapecolor.add(secondaryColor);

            if (SwingUtilities.isLeftMouseButton(e)) {
                appState.setActivePrimaryColor(shapecolor.get(0));
                appState.setActiveSecondaryColor(shapecolor.get(1));

            } else if (SwingUtilities.isRightMouseButton(e)) {
                appState.setActivePrimaryColor(shapecolor.get(1));
                appState.setActiveSecondaryColor(shapecolor.get(0));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Points(e.getX(), e.getY());
        appState.setEndPoint(endPoint);
        MouseMode mouseMode = appState.getActiveStartAndEndPointMode();

        switch (mouseMode) {
            case DRAW:
                CommandCreateShape newShape = new CommandCreateShape(appState, shapeList, shapeConfig);
                newShape.execute();
                break;

            case MOVE:
                MoveShapes newMove = new MoveShapes(appState, shapeList);
                newMove.execute();
                break;

            case SELECT:
                CommandSelectShape newSelect = new CommandSelectShape(appState, shapeList);
                newSelect.execute();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        appState.setStartPoint(startPoint);
    }
}