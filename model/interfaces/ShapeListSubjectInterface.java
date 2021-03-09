package model.interfaces;

import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public interface ShapeListSubjectInterface {
    void add_Shape(DrawShapeInterface shape);

    void remove_Shape(DrawShapeInterface shape);

    ArrayList<DrawShapeInterface> get_ShapeList();

    void subscribe(ShapeListObserverInterface paintCanvas);

    void unsubscribe(ShapeListObserverInterface paintCanvas);

    void observerNotification();

    void add_SelectedList(DrawShapeInterface shapes);

    ArrayList<DrawShapeInterface> get_SelectedShapesList();

    ArrayList<DrawShapeInterface> get_InternalShapesList();

    void selected_ListRemove();

    void selectedShapeListClear();

    void add_ShapesToClipboard(DrawShapeInterface shapes);

    void remove_ClipBoardShapes();

    void clear_ClipBoard();

    ArrayList<DrawShapeInterface> get_ClipBoardShapes();
}
