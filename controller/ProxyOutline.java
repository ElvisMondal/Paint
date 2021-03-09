package controller;

import model.ShapeConfiguration;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.ShapeListSubjectInterface;
import model.persistence.ApplicationState;
import view.gui.DottedEllipse;
import view.gui.DottedRect;
import view.gui.DottedTriangle;

public class ProxyOutline implements IOutline {

    CommandInterface commandInterface;
    private IApplicationState applicationState;
    private ShapeListSubjectInterface shapeList;

    private CommandSelectShape selectShape=null;
    private CommandMoveShape moveShape=null;


    public ProxyOutline(CommandInterface command, IApplicationState applicationState, ShapeListSubjectInterface shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.commandInterface = command;
        if (command instanceof CommandSelectShape) {
            selectShape = (CommandSelectShape) command;
        }
    }


    @Override
    public void outline() {
       if(selectShape.containsSelectedShape()){
           OutlineClass outlineClass =new OutlineClass(applicationState,shapeList);
           outlineClass.outline();
       }
    }
}
