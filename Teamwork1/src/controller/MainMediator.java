package controller;

import java.awt.event.ActionEvent;

import listeners.BtnDeleteListener;
import listeners.BtnEditListener;
import listeners.BtnSelectListener;
import listeners.BtnStateListener;
import listeners.BtnTransListener;
import state.ChosenSelect;
import state.ChosenState;
import state.ChosenTransition;
import state.MouseState;
import view.ButtonDelete;
import view.ButtonEdit;
import view.ButtonSelect;
import view.ButtonState;
import view.ButtonTransition;
import view.DrawCanvas;

// combining facade and mediator
public class MainMediator {

	//Singleton with Eager initialization 
	private static MainMediator mdtr = new MainMediator();
	
	private MainMediator() {}
	
	public static MainMediator getGuiMediator() {
		return mdtr;
	}
	
	//Declare
	private ButtonState buttonState;
	private ButtonSelect buttonSelect;
	private ButtonTransition buttonTransition;
	private ButtonDelete buttonDelete;
	private ButtonEdit buttonEdit;
	private DrawCanvas drawCanvas;
	private MouseState currentState;
	
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
	/*
	public ButtonState getButtonState() {
		return buttonState;
	}

	public ButtonSelect getButtonSelect() {
		return buttonSelect;
	}
	
	public ButtonTransition getButtonTransition() {
		return buttonTransition;
	}

	public DrawCanvas getDrawCanvas() {
		return drawCanvas;
	}
	*/

	
}
