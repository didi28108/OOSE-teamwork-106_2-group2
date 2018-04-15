package facadeExample;

import mediator.*;
import statediagram.*;


public class FacadeExample {
    private ModelMediator modelMediator;
    public FacadeExample() {
        this.modelMediator = ModelMediator.getInstance();
    }


    public Component getComponent(int id) {
        StateDiagram stateDiagram = modelMediator.getStateDiagram();
        return stateDiagram.getComponent(id);
    }
    /**
     * create a new group
     * @param group =組別代號
     * @return new group
     */
    public Component addNewGroup(int group) {
        Component newGroup = modelMediator.newStateDiagram();
        newGroup.setGroup(group);
        modelMediator.addComponent(newGroup);

        return newGroup;
    }
    /**
     * create a new State
     * @return new State
     */
    public Component addNewState() {
        Component newState = modelMediator.newState();
        Component group1 = modelMediator.getGroup(1);
        group1.add(newState);

        return newState;
    }
    /**
     * create a new Transition
     * @return new Transition
     */
    public Component addNewTransition() {
        Component newTransition = modelMediator.Transition();
        Component group1 = modelMediator.getGroup(1);
        group1.add(newTransition);
        
        return newTransition;
    }

    /**
     * change group
     * @param id =要更改的Component的id
     * @param newGroupNumber =新的組別代號
     */
    public void changeGroup(int id, int newGroupNumber) {
        Component c = this.getComponent(id);
        int oldGroupNumber = c.getGroup();
        StateDiagram oldGroup = modelMediator.getGroup(oldGroup);
        StateDiagram newGroup = modelMediator.getGroup(newGroupNumber);
        if (newGroup == null) {
            this.addNewGroup(newGroupNumber);
            newGroup = modelMediator.getGroup(newGroupNumber);
        }
        oldGroup.remove(id);
        newGroup.add(c);
        c.setGroup(newGroupNumber);
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
