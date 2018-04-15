package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import state.ChosenSelect;
import state.ChosenState;
import state.ChosenTransition;
import state.MouseState;
import statediagram.Component;
import statediagram.State;
import statediagram.StateDiagram;
import statediagram.Transition;
import view.ButtonDelete;
import view.ButtonEdit;
import view.ButtonSelect;
import view.ButtonState;
import view.ButtonTransition;
import view.DrawCanvas;
import view.EditDialog;
import view.StateDiagramEditor;
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

	private StateDiagramEditor mainFrame;
	private DrawCanvas drawCanvas;
	private MouseState currentState = ChosenSelect.getInstance(); //singleton
	private StatusPanel statusPanel;
	private EditDialog eDialog;

	private JMenuItem menuOpen;
	private JMenuItem menuSave;
	private JMenuItem menuExit;
	private JMenuItem menuDelete;
	private JMenuItem menuModify;
	private JMenuItem menuUndo;
	private JMenuItem menuRedo;

	private Component stateDiagram;
	private int selectedItemID = -1;
	
	//**************Register****************//
	public void registerButtonState(ButtonState bState) {
		// TODO Auto-generated method stub
		this.buttonState = bState;
	}

	public void registerButtonSelect(ButtonSelect bSelect) {
		// TODO Auto-generated method stub
		this.buttonSelect = bSelect;
	}

	public void registerButtonTransition(ButtonTransition bTransition) {
		// TODO Auto-generated method stub
		this.buttonTransition = bTransition;
	}

	public void registerButtonDelete(ButtonDelete bDelete) {
		// TODO Auto-generated method stub
		this.buttonDelete = bDelete;
	}
	
	public void registerButtonEdit(ButtonEdit bEdit) {
		this.buttonEdit = bEdit;
	}
	
	public void registerDrawCanvas(DrawCanvas drawCanvas) {
		// TODO Auto-generated method stub
		this.drawCanvas = drawCanvas;
	}
	
	public void registerStatusPanel(StatusPanel sp) {
		// TODO Auto-generated method stub
		this.statusPanel = sp;
	}
	
	public void registerStateDiagrame(StateDiagram sd) {
		this.stateDiagram = sd;
	}

	public void registerEditStateDialog(EditDialog editStateDialog) {
		// TODO Auto-generated method stub
		this.eDialog = editStateDialog;
	}

	public void registerMenuOpen(JMenuItem menuItemOpen) {
		// TODO Auto-generated method stub
		this.menuOpen = menuItemOpen;
	}

	public void registerMenuSave(JMenuItem menuItemSave) {
		// TODO Auto-generated method stub
		this.menuSave = menuItemSave;
	}

	public void registerMenuExit(JMenuItem menuItemExit) {
		// TODO Auto-generated method stub
		this.menuExit = menuItemExit;
	}

	public void registerMenuDelete(JMenuItem menuItemDelete) {
		// TODO Auto-generated method stub
		this.menuDelete = menuItemDelete;
	}

	public void registerMenuModify(JMenuItem menuItemModify) {
		// TODO Auto-generated method stub
		this.menuModify = menuItemModify;
	}

	public void registerMainFrame(StateDiagramEditor sde) {
		// TODO Auto-generated method stub
		this.mainFrame = sde;
	}
	
	public void registerMenuUndo(JMenuItem menuItemUndo) {
		// TODO Auto-generated method stub
		this.menuUndo = menuItemUndo;
	}

	public void registerMenuRedo(JMenuItem menuItemRedo) {
		// TODO Auto-generated method stub
		this.menuRedo = menuItemRedo;
	}
	
	/*****************/
	/*  Action Event */
	/*****************/
	public void transClick(ActionEvent e) {
		changeState(ChosenTransition.getInstance());
		this.setSelectedItemID(-1);
		System.out.println("trans btn clicked");
	}
	
	public void stateClick(ActionEvent e) {
		changeState(ChosenState.getInstance());
		this.setSelectedItemID(-1);
		System.out.println("state btn clicked");
	}
	
	public void selectClick(ActionEvent e) {
		changeState(ChosenSelect.getInstance());
		System.out.println("select btn clicked");
	}
	
	public void editClick(ActionEvent e) {
		System.out.println("Edit btn clicked");
		if(getSelectedItemID() != -1) {
			showDialog();
		}
	}
	
	public void deleteClick(ActionEvent e) {
		System.out.println("Delete btn clicked");
		this.removeComponent();
	}
	/*********/
	
	//Change mouse state and update status
	public void changeState(MouseState newState) {
		currentState = newState;
		setSelectedStateText(currentState.getMouseStateText());
	}

	// return current chosen mouse state
	public MouseState getCurrentState() {
		return currentState;
	}
	
	//****************Status************//
	//update mouse position
	public void setCoordinates(MouseEvent e) {
		// TODO Auto-generated method stub
		statusPanel.setCoordinates(e.getX(), e.getY());
	}
	
	//update selected item status
	public void setSelectedItemText() {
		String Text = "None";
		if(selectedItemID != -1) {
			Component component = stateDiagram.getComponent(selectedItemID);
			Text = component.getText();
		}
		statusPanel.setSelectedItem(Text);
	}
	
	//update chosen state status (ex. State, Transition and Select)
	public void setSelectedStateText(String text) {
		statusPanel.setSelectedState(text);
	}
	
	//*********************Diagram*********************//
	
	//return State Diagram (Composite)
	public StateDiagram getStateDiagram() {
		// TODO Auto-generated method stub
		return (StateDiagram)this.stateDiagram;
	}
	
	//draw State
	public void addState(MouseEvent e) {
		Component state = new State("", e.getPoint());
		stateDiagram.add(state);
		selectedItemID = state.getId();
		showDialog();
		drawCanvas.repaint();
	}
	
	// draw transition
	public void addTranstion(MouseEvent e, Component s1, Component s2) {
		Component trans = new Transition("", s1, s2);
		stateDiagram.add(trans);
		selectedItemID = trans.getId();
		showDialog();
		drawCanvas.repaint();
	}
	
	//Set Selected Component Text
	public void setComponentText(String text) {
		Component comp = stateDiagram.getComponent(selectedItemID);
		comp.setText(text);
		setSelectedItemText();
		drawCanvas.repaint();
	}

	//Get Selected Component Text
	public String getSelectedItemText() {
		Component comp = stateDiagram.getComponent(selectedItemID);
		return comp.getText();
	}

	//record selected(clicked) component ID
	public void setSelectedItemID(int id) {
		this.selectedItemID = id;
		setSelectedItemText();
	}
	
	//get selected(clicked) component ID
	public int getSelectedItemID() {
		return this.selectedItemID;
	}

	//remove component from state diagram by ID
	public void removeComponent() {
		if(selectedItemID != -1) {
			stateDiagram.remove(selectedItemID);
			System.out.println("deleted item" + selectedItemID);
			this.setSelectedItemID(-1);
		}
		drawCanvas.repaint();
	}
	
	//**************Mouse Event***********//
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

	//Change Position and repaint when drag the component
	public void changePoint(MouseEvent e, Component comp) {
		// TODO Auto-generated method stub
		comp.changePoint(e.getPoint());
		drawCanvas.repaint();
	}
	
	
	//***************Edit Dialog***************//
	//show up the edit dialog
	public void showDialog() {
		if(eDialog == null) {
			eDialog = new EditDialog();
		}
		eDialog.showDialog();
	}
	
	public void closeMainFrame() {
		mainFrame.dispose();
	}



}
