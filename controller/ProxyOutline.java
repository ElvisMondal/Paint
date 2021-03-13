package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.ShapeSubjectList;

public class ProxyOutline implements IOutline {

    CommandInterface commandInterface;
    private IApplicationState applicationState;
    private ShapeSubjectList shapeList;

    private CommandSelectShape selectShape=null;
    private MoveShapes moveShape=null;


    public ProxyOutline(CommandInterface command, IApplicationState applicationState, ShapeSubjectList shapeList) {
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
