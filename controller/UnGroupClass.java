package controller;

import model.ShapeConfiguration;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeListSubjectInterface;
import view.gui.PaintCanvas;
import view.interfaces.DrawShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class UnGroupClass implements IUndoable,CommandInterface {

    private ArrayList<DrawShapeInterface> UnGroup;
    private ShapeListSubjectInterface shapeList;
    private IApplicationState applicationState;
    DrawShapeInterface gp;



    public UnGroupClass(ShapeListSubjectInterface shapeList, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;

    }


    @Override
    public void execute() {

        UnGroup = new ArrayList<>();


        for (DrawShapeInterface shape2 : shapeList.get_ShapeList()) {


                if (shape2 instanceof Group)

                    gp = shape2;


        }

        shapeList.remove_Shape(gp);


        CommandHistory.add(this);
    }


    @Override
    public void undo() {

            shapeList.add_Shape(gp);

    }

    @Override
    public void redo() {

            shapeList.remove_Shape(gp);


    }

}
