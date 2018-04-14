package state;

import java.awt.event.MouseEvent;

import controller.ViewMediator;
import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.StateDiagram;

public class ChosenSelect implements MouseState{
	//singleton
	private static ChosenSelect instance = null;
	private boolean check = false;		//為了判別使用哪個功能，避免同時觸發
	private Component deCheck = null;
			
	public ChosenSelect() {}

	public static ChosenSelect getInstance() {

		System.out.println("Curernt Mouse State: select");
		if (instance == null) {

			return new ChosenSelect();
		}

		return instance;

	}

	@Override
	public void mouseClicked(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		for(Component de : sd.getComponentList()) {
			if(de.checkPoint(e.getPoint()) || de.checkLinePoint(e.getPoint())) {
				if(deCheck == null) {
					deCheck = de;
					System.out.println("Pressed item");
				}
			}
		}
	}

	@Override
	public void mouseReleased(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		deCheck = null;
	}

	@Override
	public void mouseDragged(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		for(Component de : sd.getComponentList()) {
			if(de.checkPoint(e.getPoint())){
				if(deCheck == de) {
					vMdtr.changePoint(e, de);
				}
			}
		}
	}
	
}
