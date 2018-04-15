package state;

import java.awt.event.MouseEvent;

import mediator.ViewMediator;
import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.State;
import statediagram.StateDiagram;

public class ChosenState implements MouseState{
	//singleton
	private static ChosenState instance = null;
	private String text = "State";
	public ChosenState() {}

	public static ChosenState getInstance() {
		System.out.println("Curernt Mouse State: state");
		if (instance == null) {
			return new ChosenState();
		}
		return instance;
	}

	@Override
	public void mouseClicked(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		vMdtr.addState(e);
		vMdtr.changeState(ChosenSelect.getInstance());
	}

	@Override
	public void mousePressed(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMouseStateText() {
		// TODO Auto-generated method stub
		return text;
	}

}
