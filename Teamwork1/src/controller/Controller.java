package controller;

import java.awt.event.MouseEvent;

import mediator.ModelMediator;
import mediator.ViewMediator;
import statediagram.Component;
import statediagram.State;
import statediagram.StateDiagram;
import statediagram.Transition;

public class Controller {
	ViewMediator vMdtr = ViewMediator.getInstance();
	ModelMediator mMdtr = ModelMediator.getInstance();
	
	public Controller() {
		vMdtr.setController(this);
		mMdtr.setController(this);
	}
	
	//*********************Diagram*********************//
	
	//draw State
	public void addState(MouseEvent e) {
		int id = mMdtr.addState(e.getPoint());
		vMdtr.setSelectedItemID(id);
		vMdtr.showDialog();
		vMdtr.repaint();
	}
	
	// draw transition
	public void addTranstion(MouseEvent e, Component s1, Component s2) {
		int id = mMdtr.addTranstion(e.getPoint(), s1, s2);
		vMdtr.setSelectedItemID(id);
		vMdtr.showDialog();
		vMdtr.repaint();
	}
	
	//Set Selected Component Text
	public void setComponentText(String text) {
		mMdtr.setComponentText(text, vMdtr.getSelectedItemID());
		vMdtr.setSelectedItemText();
		vMdtr.repaint();
	}

	//Get Selected Component Text
	public String getSelectedItemText() {
		return mMdtr.getSelectedItemText(vMdtr.getSelectedItemID());
	}
	

	//remove component from state diagram by ID
	public void removeComponent() {
		int selectedItemID = vMdtr.getSelectedItemID();
		if(selectedItemID != -1) {
			mMdtr.removeComponent(selectedItemID);
			vMdtr.setSelectedItemID(-1);
		}
		vMdtr.repaint();
	}

	public StateDiagram getStateDiagram() {
		// TODO Auto-generated method stub
		return mMdtr.getStateDiagram();
	}
	
}
