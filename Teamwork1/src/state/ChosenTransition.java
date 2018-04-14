package state;

import java.awt.event.MouseEvent;

import controller.ViewMediator;
import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.StateDiagram;

public class ChosenTransition implements MouseState{
	//singleton
	private static ChosenTransition instance = null;
	private boolean PointCheck = false;
	private Component s1;		//起始座標(s代表StateDiagram才有用)
	private Component s2;		//結束座標
	
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
				}
				else if(s1.getPoint() != de.getPoint()) {
					s2 = de;
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
	
}
