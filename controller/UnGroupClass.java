package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeSubjectList;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;

public class UnGroupClass implements IUndoable,CommandInterface {

    private ArrayList<DrawShapeInterface> UnGroup;
    private ShapeSubjectList shapeList;
    private IApplicationState applicationState;
    DrawShapeInterface gp;



    public UnGroupClass(ShapeSubjectList shapeList, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;

    }


    @Override
    public void execute() {

        UnGroup = new ArrayList<>();


        for (DrawShapeInterface shape2 : shapeList.getShapesLists()) {


                if (shape2 instanceof Group)

                    gp = shape2;


        }

        shapeList.removeShap(gp);


        CommandHistory.add(this);
    }


    @Override
    public void undo() {

            shapeList.addShap(gp);

    }

    @Override
    public void redo() {

            shapeList.removeShap(gp);


    }

}
