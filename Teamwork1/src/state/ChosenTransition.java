package state;

import java.awt.event.MouseEvent;

import mediator.ViewMediator;
import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.StateDiagram;

public class ChosenTransition implements MouseState{
	//singleton
	private static ChosenTransition instance = null;
	private boolean PointCheck = false;
	private Component s1;		//�_�l�y��(s�N��StateDiagram�~����)
	private Component s2;		//�����y��
	private String text = "Transition";
	
	public ChosenTransition() {}

	public static ChosenTransition getInstance() {

		System.out.println("Curernt Mouse State: transition");
		if (instance == null) {

			return new ChosenTransition();
		}

		return instance;

	}

	@Override
	public void mouseClicked(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		for (Component de : sd.getComponentList()) {
			
			if (de.checkPoint(e.getPoint())) {		
				
				if(s1 == null) {
					s1 = de;
					System.out.println("Clicked state 1: " + s1.getClassName());
				}
				else if(s1.getPoint() != de.getPoint()) {
					s2 = de;
					System.out.println("Clicked state 2: " + s2.getClassName());
					PointCheck = true;
				}
			}
		}

		if (PointCheck) {
			vMdtr.addTranstion(e, s1, s2);
			PointCheck = false;

			vMdtr.changeState(ChosenSelect.getInstance());
		}
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
