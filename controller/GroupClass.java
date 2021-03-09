package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.ShapeListSubjectInterface;
import view.gui.DottedEllipse;
import view.gui.DottedRect;
import view.gui.DottedTriangle;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;


public class GroupClass implements CommandInterface{
    private ShapeListSubjectInterface shapeList,shapeto;
    private DrawShapeInterface selectedShape;
    private DrawShapeInterface l,b;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface shapes, sp;
    int n=0,p,u=0,v=0;

    ArrayList<DrawShapeInterface>lp=new ArrayList<>();


    public GroupClass(ShapeListSubjectInterface shapeList, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;

    }

    @Override
    public void execute() {


            p=shapeList.get_ShapeList().size();


            l = shapeList.get_ShapeList().get(0);
            // l.getAdjustedStart();

            b=shapeList.get_ShapeList().get(p-1);

            // b.getAdjustedEnd();

            shapeConfiguration = applicationState.get_CurrentShapeConfigs();


            for (DrawShapeInterface shape : shapeList.get_ShapeList()) {

                u=u+shape.getWidth();
                v=v+shape.getHeight();

                if(shape instanceof DottedRect) {
                    sp = shape;
                    lp.add(sp);
                }
                else if (shape instanceof DottedEllipse) {
                    sp = shape;
                    lp.add(sp);
                }
                else if (shape instanceof DottedTriangle) {
                    sp = shape;
                    lp.add(sp);
                }


            }

            for(DrawShapeInterface sh:lp) {
                shapeList.remove_Shape(sh);
            }

            Group commandGroup=new Group(shapeConfiguration,l.getAdjustedStart().getX(),l.getAdjustedStart().getY(),u,v);

            shapes= new Group(shapeConfiguration,l.getAdjustedStart().getX(),l.getAdjustedStart().getY(),u,v);
            commandGroup.addChild(shapes);
            this.shapeList.add_Shape(commandGroup);

        }



}

