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
	private String text = "Select";
			
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
					System.out.println("Pressed item： " + deCheck.getClassName() + deCheck.getId());
				}
				vMdtr.setSelectedItemID(de.getId());
			}
		}
		if(deCheck == null) {
			vMdtr.setSelectedItemID(-1);
		}
	}

	@Override
	public void mouseReleased(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		deCheck = null;
		check = false;
	}

	@Override
	public void mouseDragged(ViewMediator vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		for(Component de : sd.getComponentList()) {
			if(!check) {
				if(de.checkPoint(e.getPoint())){
					check = true; //只判斷第一次拖拉位置，接下來只要不放開滑鼠都可以滑動物件，順暢很多
				}
			}
			if(deCheck == de) {
				vMdtr.changePoint(e, deCheck);
			}
			
		}
	}

	@Override
	public String getMouseStateText() {
		// TODO Auto-generated method stub
		return text;
	}
	
}
