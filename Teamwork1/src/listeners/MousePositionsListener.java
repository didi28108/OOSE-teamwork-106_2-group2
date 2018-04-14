package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import controller.ViewMediator;

public class MousePositionsListener implements MouseMotionListener{
private ViewMediator mainMtr;
	
	public MousePositionsListener(ViewMediator mainMtr) {
		this.mainMtr = mainMtr;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Dragged");
		mainMtr.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mainMtr.setCoordinates(e);
	}
}
