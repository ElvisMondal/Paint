package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;
import view.gui.DottedEllipse;
import view.gui.DottedRect;
import view.gui.DottedTriangle;
import view.interfaces.DrawShapeInterface;

import java.util.ArrayList;


public class GroupClass implements CommandInterface{
    private ShapeSubjectList shapeList,shapeto;
    private DrawShapeInterface selectedShape;
    private DrawShapeInterface l,b;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private DrawShapeInterface shapes, sp;
    int n=0,p,u=0,v=0;

    ArrayList<DrawShapeInterface>lp=new ArrayList<>();


    public GroupClass(ShapeSubjectList shapeList, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;

    }

    @Override
    public void execute() {


            p=shapeList.getShapesLists().size();


            l = shapeList.getShapesLists().get(0);
            // l.getAdjustedStart();

            b=shapeList.getShapesLists().get(p-1);

            // b.getAdjustedEnd();

            shapeConfiguration = applicationState.getCurrentShapeConfigs();


            for (DrawShapeInterface shape : shapeList.getShapesLists()) {

                u=u+shape.getWidths();
                v=v+shape.getHeights();

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
                shapeList.removeShap(sh);
            }

            Group commandGroup=new Group(shapeConfiguration,l.getAdjustedsStarts().getX(),l.getAdjustedsStarts().getY(),u,v);

            shapes= new Group(shapeConfiguration,l.getAdjustedsStarts().getX(),l.getAdjustedsStarts().getY(),u,v);
            commandGroup.addChild(shapes);
            this.shapeList.addShap(commandGroup);

        }



}

