package mediator;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import controller.Controller;
import flyweight.ColorFactory;
import observer.Observer;
import statediagram.*;
import memento.*;
import observer.StateSubject;
import observer.TransitionSubject;

public class ModelMediator {
	private static ModelMediator instance = new ModelMediator();
	private Controller controller;
	private ModelMediator() {
		this.stateDiagram = new StateDiagram();
		this.stateDiagram.setGroup(0);
		this.addComponent(this.newStateDiagram());
	}
	public static ModelMediator getInstance() {
		return instance;
	}
	
	public void setController(Controller ctrl) {
		this.controller = ctrl;
	}

	private MementoCaretaker mementoCaretaker = new MementoCaretaker();
	private StateDiagram stateDiagram;
	private StateSubject stateSubject = new StateSubject();
	private TransitionSubject transitionSubject = new TransitionSubject();
	private ColorFactory colorFactory = new ColorFactory();

	/****************************************/
	
    public Color getColorFromFactory(String color) {
        return this.colorFactory.getColor(color);
	}

	public ArrayList<String> getColorStringList() {
		return this.colorFactory.getColorStringList();
	}

	/****************************************/
	
    
	/**
	 * 創建新的 StateDiagram
	 * @return new StateDiagram()
	 */
	public StateDiagram newStateDiagram() {
		return new StateDiagram();
	}
	/**
	 * 創建新的 State
	 * @return new State()
	 */
	public State newState() {
		return new State();
	}
	/**
	 * 創建新的 Transition
	 * @return new Transition()
	 */
	public Transition newTransition() {
		return new Transition();
	}

	/**
	 * 取得指定的group
	 * @param group =group's number
	 * @return the group
	 */
	public Component getGroup(int group) {
		return this.stateDiagram.getGroup(group);
	}

    public StateDiagram getStateDiagram() {
		return this.stateDiagram;
	}
	
	public void setStateDiagram(StateDiagram stateDiagram) {
		this.stateDiagram = stateDiagram;
	}

	
	public void addComponent(Component newComponent) {
		this.stateDiagram.add(newComponent);
	}
	
	public ObjectStatusMemento saveStateDiagram() {
		return this.stateDiagram.save();
	}
	public void restoreStateDiagram(ObjectStatusMemento previousMemento) {
		this.stateDiagram.restore(previousMemento);
	}

	public void stateDiagramAttachSubject() {
		this.stateDiagram.attachSubject();
	}

	/****************************************/

	public void addMemento(ObjectStatusMemento memento) {
		this.mementoCaretaker.addMemento(memento);
	}


	public boolean canUndo() {
        return this.mementoCaretaker.canUndo();
    }
	/**
     * 回傳上一步的Memento, 不存在時會回傳最初的 (list[0])
     * @return 上一步的Memento
     */
	public ObjectStatusMemento undo() {
		return this.mementoCaretaker.undo();
	}


	public boolean canRedo() {
        return this.mementoCaretaker.canRedo();
    }
	/**
     * 回傳下一步的Memento, 不存在時會回傳現在的 (list[size()-1])
     * @return 下一步的Memento
     */
    public ObjectStatusMemento redo() {
		return this.mementoCaretaker.redo();
	}

	/****************************************/

	public void attachStateSubject(Observer observer) {
		this.stateSubject.attach(observer);
	}
	public void detachStateSubject(Observer observer) {
		this.stateSubject.detach(observer);
	}
	public void detachAllStateSubject() {
		this.stateSubject.detachAll();
	}

	public void attachTransitionSubject(Observer observer) {
		this.transitionSubject.attach(observer);
	}
	public void detachTransitionSubject(Observer observer) {
		this.transitionSubject.detach(observer);
	}
	public void detachAllTransitionSubject() {
		this.transitionSubject.detachAll();
	}
	
	public void changeColor(String color, StateDiagram sd, int id) {
		// TODO Auto-generated method stub
		Component comp = sd.getComponent(id);
		comp.changeColor(color);
	}
	
	/*******State Diagram*******/
	public int addState(Point p) {
		Component state = new State("", p);
		stateDiagram.add(state);
		return state.getId();
	}
	
	// draw transition
	public int addTranstion(Point p, Component s1, Component s2) {
		Component trans = new Transition("", s1, s2);
		stateDiagram.add(trans);
		return trans.getId();
	}
	
	//Set Selected Component Text
	public void setComponentText(String text, int selectedItemID) {
		Component comp = stateDiagram.getComponent(selectedItemID);
		comp.setText(text);
	}
	
	//Get Selected Component Text
	public String getSelectedItemText(int selectedItemID) {
		Component comp = stateDiagram.getComponent(selectedItemID);
		return comp.getText();
	}
	
	//remove component from state diagram by ID
	public void removeComponent(int selectedItemID) {
		stateDiagram.remove(selectedItemID);
		System.out.println("deleted item" + selectedItemID);
	}
}