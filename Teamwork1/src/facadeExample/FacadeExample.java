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
     * change a Component's color with another Component's color
     * @param changeC =which will change color
     * @param colorSource =color will same as this
     */
    public void changeComponentToSameColor(Component changeC, Component colorSource) {
        changeC.setColor(colorSource.getColor());
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
        this.changeComponentToSameColor(newState, group1);

        return newState;
    }
    /**
     * create a new Transition
     * @return new Transition
     */
    public Component addNewTransition() {
        Component newTransition = modelMediator.newTransition();
        Component group1 = modelMediator.getGroup(1);
        group1.add(newTransition);
        this.changeComponentToSameColor(newTransition, group1);
        
        return newTransition;
    }

    /**
     * change group
     * @param id =component's id which you want change group
     * @param newGroupNumber =it's new group number
     */
    public void changeGroup(int id, int newGroupNumber) {
        Component c = this.getComponent(id);
        int oldGroupNumber = c.getGroup();
        Component oldGroup = modelMediator.getGroup(oldGroupNumber);
        Component newGroup = modelMediator.getGroup(newGroupNumber);
        if (newGroup == null) {
            this.addNewGroup(newGroupNumber);
            newGroup = modelMediator.getGroup(newGroupNumber);
        }
        oldGroup.remove(id);
        newGroup.add(c);
        this.changeComponentToSameColor(c, newGroup);
        c.setGroup(newGroupNumber);
    }
    /**
     * change group's color
     * @param groupNumber =group's number
     * @param color =new color
     */
    public void changeGroupColor(int groupNumber, String color) {
        Component group = modelMediator.getGroup(groupNumber);
        group.changeColor(color);
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
