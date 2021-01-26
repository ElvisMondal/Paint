package model.interfaces;

import controller.Points;
import model.ShapeColor;
import model.MouseMode;
import model.ShapeShadingType;
import model.ShapeConfiguration;
import model.ShapeType;
import view.interfaces.MouseAdapterObserverInterface;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeConfiguration get_CurrentShapeConfig();


    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    MouseMode getActiveMouseMode();

    void setStartPoint(Points startPoint);

    void setEndPoint(Points endPoint);
    Points getStartPoint();

    Points getEndPoint();

    Points getAdjustedStart();

    Points getAdjustedEnd();

    void setActivePrimaryColor(ShapeColor activePrimaryColor);

    void setActiveSecondaryColor(ShapeColor activeSecondaryColor);


    void observerRegister(MouseAdapterObserverInterface o);

    void observersNotification();
}
