package model.persistence;

import controller.Points;
import model.ShapeColor;
import model.MouseMode;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import view.interfaces.MouseAdapterObserverInterface;

import java.awt.*;
import java.util.ArrayList;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ArrayList<MouseAdapterObserverInterface> mouseObservers = new ArrayList<>();
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;
    private Points startPoint, endPoint, adjustedStart, adjustedEnd;
    private int width, height;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }


    @Override
    public ShapeConfiguration get_CurrentShapeConfig() {
        ShapeConfiguration shapeConfig = new ShapeConfiguration();
        shapeConfig.setPrimaryColor(activePrimaryColor);
        shapeConfig.setSecondaryColor(activeSecondaryColor);
        shapeConfig.setShadingType(activeShapeShadingType);
        shapeConfig.setShapeType(activeShapeType);
        shapeConfig.setEndPoint(endPoint);
        shapeConfig.setStartPoint(startPoint);
        shapeConfig.setAdjustedStart(adjustedStart);
        shapeConfig.setAdjustedEnd(adjustedEnd);
        shapeConfig.setWidth(width);
        shapeConfig.setHeight(height);
        return shapeConfig;
    }


    @Override
    public void setActivePrimaryColor(ShapeColor activePrimaryColor) {
        this.activePrimaryColor = activePrimaryColor;
    }

    @Override
    public void setActiveSecondaryColor(ShapeColor activeSecondaryColor) {
        this.activeSecondaryColor = activeSecondaryColor;
    }

    @Override
    public void setStartPoint(Points startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public void setEndPoint(Points endPoint) {
        this.endPoint = endPoint;
    }

    public void setWidth(int width) {
        Points start = getAdjustedStart();
        Points end = getAdjustedEnd();
        this.width = end.getX() - start.getX();
    }

    public void setHeight(int height) {
        Points start = getAdjustedStart();
        Points end = getAdjustedEnd();
        this.height = end.getY() - start.getY();
    }

    @Override
    public void setActiveShape() {
       /* activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
        System.out.println("ShapeConfiguration: " + activeShapeType);*/
    }

    @Override
    public void setActivePrimaryColor() {
        /*activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        System.out.println("Primary Color " + activePrimaryColor);*/
    }

    @Override
    public void setActiveSecondaryColor() {
        /*activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        System.out.println("Secondary Color: " + activeSecondaryColor);*/
    }

    @Override
    public void setActiveShadingType() {
        /*activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
        System.out.println("Shading Type: " + activeShapeShadingType);*/
    }

    @Override
    public void setActiveStartAndEndPointMode() {
       /* activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
        System.out.println("Mouse Mode: " + activeMouseMode);*/
        observersNotification();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }


    @Override
    public Points getStartPoint() {
        return startPoint;
    }

    @Override
    public Points getEndPoint() {
        return endPoint;
    }

    @Override
    public Points getAdjustedStart() {
        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        adjustedStart = new Points(startX, startY);
        return adjustedStart;
    }

    @Override
    public Points getAdjustedEnd() {
        int endX = Math.max(startPoint.getX(), endPoint.getX());
        int endY = Math.max(startPoint.getY(), endPoint.getY());
        adjustedEnd = new Points(endX, endY);
        return adjustedEnd;
    }

    public void setAdjustedStart(Points adjustedStart) {
        this.adjustedStart = adjustedStart;
    }

    public void setAdjustedEnd(Points adjustedEnd) {
        this.adjustedEnd = adjustedEnd;
    }

    @Override
    public void observerRegister(MouseAdapterObserverInterface o) {
        mouseObservers.add(o);
    }

    @Override
    public void observersNotification() {
        for (MouseAdapterObserverInterface observer : mouseObservers) {
            observer.execute();
        }
    }
}