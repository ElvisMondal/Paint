package controller;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.ShapeSubjectList;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private ShapeSubjectList shapeList;
    private ShapeConfiguration shapeConfiguration;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeSubjectList shapeList, ShapeConfiguration shapeConfiguration) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new Undos().execute());
        uiModule.addEvent(EventName.REDO, () -> new Redos().execute());
        uiModule.addEvent(EventName.COPY, () -> new Copy(applicationState, shapeList, shapeConfiguration).execute());
        uiModule.addEvent(EventName.PASTE, () ->new Paste(applicationState, shapeList, shapeConfiguration).execute());
        uiModule.addEvent(EventName.DELETE, () ->new Delete(applicationState, shapeList, shapeConfiguration).execute());
        uiModule.addEvent(EventName.GROUP, () ->new GroupClass(shapeList, applicationState).execute());
        uiModule.addEvent(EventName.UNGROUP, () ->new UnGroupClass(shapeList,applicationState).execute());
    }
}
