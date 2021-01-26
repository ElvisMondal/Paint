package model;

import model.interfaces.ShapeListObserverInterface;
import model.interfaces.ShapeListSubjectInterface;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class ShapeList  implements ShapeListSubjectInterface {
        private final ArrayList<DrawShapeInterface> internalShapesList;
        private final ArrayList<ShapeListObserverInterface> observers;
        private final ArrayList<DrawShapeInterface> selectedShapesList;
        private final ArrayList<DrawShapeInterface> clipBoard;


        public ShapeList() {
            internalShapesList = new ArrayList<DrawShapeInterface>();
            observers = new ArrayList<ShapeListObserverInterface>();
            selectedShapesList = new ArrayList<DrawShapeInterface>();
            clipBoard = new ArrayList<DrawShapeInterface>();

        }

        public void add_Shape(DrawShapeInterface shapes) {
            //  System.out.println("ShapeList adding");
            internalShapesList.add(shapes);
            observerNotification();
        }

        public void remove_Shape(DrawShapeInterface shape) {
            //  System.out.println("ShapeList adding");
            internalShapesList.remove(shape);
            observerNotification();
        }

        public ArrayList<DrawShapeInterface> get_ShapeList() {
            return internalShapesList;
        }

        @Override
        public void subscribe(ShapeListObserverInterface observer) {
            observers.add(observer);
        }


        @Override
        public void unsubscribe(ShapeListObserverInterface observer) {
            observers.remove(observer);
        }

        @Override
        public void observerNotification() {


            for (ShapeListObserverInterface newObserver : observers) {
                newObserver.updateShapeList();
            }
        }


        public void add_SelectedList(DrawShapeInterface shapes) {
            selectedShapesList.add(shapes);

        }

        public void selected_ListRemove() {
            selectedShapesList.removeAll(selectedShapesList);
            observerNotification();

        }

        public void selectedShapeListClear() {
            selectedShapesList.clear();
        }

        public ArrayList<DrawShapeInterface> get_SelectedShapesList() {
            return selectedShapesList;
        }

        //Clipboard Shapelist

        public void add_ShapesToClipboard(DrawShapeInterface shapes) {
            clipBoard.add(shapes);

        }

        public void remove_ClipBoardShapes() {
            clipBoard.removeAll(selectedShapesList);
            observerNotification();

        }

        public void clear_ClipBoard() {
            clipBoard.clear();
        }

        public ArrayList<DrawShapeInterface> get_ClipBoardShapes() {
            return clipBoard;
        }

}


