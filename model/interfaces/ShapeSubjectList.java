package model.interfaces;

import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public interface ShapeSubjectList {
    void addShap(DrawShapeInterface shape);

    void removeShap(DrawShapeInterface shape);

    ArrayList<DrawShapeInterface> getShapesLists();

    void subscribes(ShapeObserverList paintCanvas);

    void unsubscribes(ShapeObserverList paintCanvas);

    void observersNotification();

    void addSelectedsLists(DrawShapeInterface shapes);

    ArrayList<DrawShapeInterface> getSelectedsShapesLists();

    ArrayList<DrawShapeInterface> getInternalsShapesLists();

    void selectedsListsRemoves();

    void selectedsShapeListsClears();

    void addsShapesToClipboards(DrawShapeInterface shapes);

    void removesClipBoardShapess();

    void clearsClipBoards();

    ArrayList<DrawShapeInterface> getsClipBoardsShapes();
}
