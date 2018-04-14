package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import listeners.BtnDeleteListener;
import listeners.BtnEditListener;
import listeners.BtnSelectListener;
import listeners.BtnStateListener;
import listeners.BtnTransListener;
import listeners.MousePositionsListener;
import listeners.MyMouseListener;
import state.ChosenSelect;
import state.ChosenState;
import state.ChosenTransition;
import state.MouseState;
import statediagram.Component;
import statediagram.StateDiagram;
import view.ButtonDelete;
import view.ButtonEdit;
import view.ButtonSelect;
import view.ButtonState;
import view.ButtonTransition;
import view.DrawCanvas;
import view.StatusPanel;

// combining facade and mediator
public class ViewMediator {

	//Singleton with Eager initialization 
	private static ViewMediator mdtr = new ViewMediator();
	
	private ViewMediator() {}
	
	public static ViewMediator getGuiMediator() {
		return mdtr;
	}
	
	//Declare
	private ButtonState buttonState;
	private ButtonSelect buttonSelect;
	private ButtonTransition buttonTransition;
	private ButtonDelete buttonDelete;
	private ButtonEdit buttonEdit;
	private DrawCanvas drawCanvas;
	private MouseState currentState = ChosenSelect.getInstance();
	private StatusPanel statusPanel;
	private Component stateDiagram;
	
	//Register
	public void registerButtonState(ButtonState bState) {
		// TODO Auto-generated method stub
		buttonState = bState;
		buttonState.addActionListener(new BtnStateListener(this));
	}

	public void registerButtonSelect(ButtonSelect bSelect) {
		// TODO Auto-generated method stub
		buttonSelect = bSelect;
		buttonSelect.addActionListener(new BtnSelectListener(this));
	}

	public void registerButtonTransition(ButtonTransition bTransition) {
		// TODO Auto-generated method stub
		buttonTransition = bTransition;
		buttonTransition.addActionListener(new BtnTransListener(this));
	}

	public void registerButtonDelete(ButtonDelete bDelete) {
		// TODO Auto-generated method stub
		buttonDelete = bDelete;
		buttonDelete.addActionListener(new BtnDeleteListener(this));
	}
	
	public void registerButtonEdit(ButtonEdit bEdit) {
		buttonEdit = bEdit;
		buttonEdit.addActionListener(new BtnEditListener(this));
	}
	
	public void registerDrawCanvas(DrawCanvas drawCanvas) {
		// TODO Auto-generated method stub
		this.drawCanvas = drawCanvas;
		this.drawCanvas.addMouseMotionListener(new MousePositionsListener(this));
		this.drawCanvas.addMouseListener(new MyMouseListener(this));
	}
	
	public void registerStatusPanel(StatusPanel sp) {
		// TODO Auto-generated method stub
		statusPanel = sp;
	}
	
	public void registerStateDiagrame(StateDiagram sd) {
		stateDiagram = sd;
	}
	
	
	// Action Event
	public void btnTransClick(ActionEvent e) {
		changeState(ChosenTransition.getInstance());
		System.out.println("trans btn clicked");
	}
	
	public void btnStateClick(ActionEvent e) {
		changeState(ChosenState.getInstance());
		System.out.println("state btn clicked");
	}
	
	public void btnSelectClick(ActionEvent e) {
		changeState(ChosenSelect.getInstance());
		System.out.println("select btn clicked");
	}
	
	public void btnEditClick(ActionEvent e) {
		System.out.println("edit btn clicked");
	}
	
	public void btnDeleteClick(ActionEvent e) {
		System.out.println("Delete btn clicked");
	}
	
	public void changeState(MouseState newState) {
		currentState = newState;
	}

	public void setCoordinates(MouseEvent e) {
		// TODO Auto-generated method stub
		statusPanel.setCoordinates(e.getX(), e.getY());
	}
	
	public MouseState getCurrentState() {
		return currentState;
	}


	public StateDiagram getStateDiagram() {
		// TODO Auto-generated method stub
		return (StateDiagram)this.stateDiagram;
	}
	
	//call drawCanvas to State
	public void addState(MouseEvent e) {
		drawCanvas.addState(e.getPoint());
	}
	
	public void addTranstion(MouseEvent e, Component s1, Component s2) {
		drawCanvas.addTrans(e.getPoint(), s1, s2);
	}

	public void mouseClicked(MouseEvent e) {
		currentState.mouseClicked(this, e);
	}
	
	public void mouseDragged(MouseEvent e) {
		currentState.mouseDragged(this, e);
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mousePressed(this, e);
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mouseReleased(this, e);
	}

	public void changePoint(MouseEvent e, Component comp) {
		// TODO Auto-generated method stub
		drawCanvas.changePoint(e, comp);
	}
	
}
