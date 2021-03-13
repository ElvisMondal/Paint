package view.gui;

import controller.CommandCreateShape;
import controller.Points;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawer extends MouseAdapter {
    private Points startPoint;
    private Points endPoint;
    private IApplicationState applicationState;
    private ShapeSubjectList shapeList;
    private ShapeConfiguration shapeConfiguration;
    ArrayList<ShapeColor> shapecolor = new ArrayList();


    public Drawer(IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        ShapeColor primaryColor = applicationState.getActivePrimaryColor();
        shapecolor.add(primaryColor);
        ShapeColor secondaryColor = applicationState.getActiveSecondaryColor();
        shapecolor.add(secondaryColor);

        if (SwingUtilities.isLeftMouseButton(e)) {
            applicationState.setActivePrimaryColor(shapecolor.get(0));
            applicationState.setActiveSecondaryColor(shapecolor.get(1));

        } else if (SwingUtilities.isRightMouseButton(e)) {
            applicationState.setActivePrimaryColor(shapecolor.get(1));
            applicationState.setActiveSecondaryColor(shapecolor.get(0));
        }
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Points(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        CommandCreateShape newShape = new CommandCreateShape(applicationState, shapeList, shapeConfiguration);
        newShape.execute();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        applicationState.setStartPoint(startPoint);
    }
}
