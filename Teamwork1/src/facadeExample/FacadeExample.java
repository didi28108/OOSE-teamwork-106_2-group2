package facadeExample;

import mediator.*;
import statediagram.*;


public class FacadeExample {
    private ModelMediator modelMediator;
    public FacadeExample() {
        this.modelMediator = ModelMediator.getInstance();
    }


    /**
     * 新增一個group
     * @param group =組別代號
     */
    public void addNewGroup(int group) {
        StateDiagram newGroup = modelMediator.newStateDiagram();
        newGroup.setGroup(group);
        modelMediator.addComponent(newGroup);
    }


    public void saveAction() {
        modelMediator.addMemento(modelMediator.saveStateDiagram());
    }

    public void detachAllSubject() {
        modelMediator.detachAllStateSubject();
        modelMediator.detachAllTransitionSubject();
    }
    public void undoAction() {
        this.detachAllSubject();
        modelMediator.restoreStateDiagram(modelMediator.undo());
    }
    public void redoAction() {
        this.detachAllSubject();
        modelMediator.restoreStateDiagram(modelMediator.redo());
    }
}
