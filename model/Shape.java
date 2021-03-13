package model;

import model.interfaces.ShapeObserverList;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class Shape implements ShapeSubjectList {


    private final ArrayList<DrawShapeInterface> internalShapesList;
        private final ArrayList<ShapeObserverList> observers;
        private final ArrayList<DrawShapeInterface> selectedShapesList;
        private final ArrayList<DrawShapeInterface> clipBoard;


        public Shape() {
            internalShapesList = new ArrayList<DrawShapeInterface>();
            observers = new ArrayList<ShapeObserverList>();
            selectedShapesList = new ArrayList<DrawShapeInterface>();
            clipBoard = new ArrayList<DrawShapeInterface>();

        }

        public void addShap(DrawShapeInterface shapes) {

            internalShapesList.add(shapes);
            observersNotification();

        }

        public void removeShap(DrawShapeInterface shape) {

            internalShapesList.remove(shape);
            observersNotification();
        }

        public ArrayList<DrawShapeInterface> getShapesLists() {
            return internalShapesList;
        }

        @Override
        public void subscribes(ShapeObserverList observer) {
            observers.add(observer);
        }


        @Override
        public void unsubscribes(ShapeObserverList observer) {
            observers.remove(observer);
        }

        @Override
        public void observersNotification() {


            for (ShapeObserverList newObserver : observers) {
                newObserver.updateShapeLists();
            }
        }


        public void addSelectedsLists(DrawShapeInterface shapes) {
            selectedShapesList.add(shapes);

        }

        public void selectedsListsRemoves() {
            selectedShapesList.removeAll(selectedShapesList);
            observersNotification();

        }

        public void selectedsShapeListsClears() {
            selectedShapesList.clear();
        }

        public ArrayList<DrawShapeInterface> getSelectedsShapesLists() {
            return selectedShapesList;
        }

        public ArrayList<DrawShapeInterface> getInternalsShapesLists() {
        return internalShapesList;
    }


        //Clipboard Shapelist

        public void addsShapesToClipboards(DrawShapeInterface shapes) {
            clipBoard.add(shapes);

        }

        public void removesClipBoardShapess() {
            clipBoard.removeAll(selectedShapesList);
            observersNotification();

        }

        public void clearsClipBoards() {
            clipBoard.clear();
        }

        public ArrayList<DrawShapeInterface> getsClipBoardsShapes() {
            return clipBoard;
        }

}


