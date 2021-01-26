package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeConfiguration;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.*;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
//import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){

        ShapeList shapeList = new ShapeList();
        ShapeConfiguration shapeConfig = new ShapeConfiguration();
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);



        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));

        IJPaintController paintController = new JPaintController(uiModule, appState, shapeList, shapeConfig);
        MouseObserver mouseObserver = new MouseObserver(appState, paintCanvas, shapeList, shapeConfig);
        mouseObserver.execute();
        paintController.setup();
    }
}
