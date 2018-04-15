package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import controller.ViewMediator;

public class MousePositionsListener implements MouseMotionListener{
	private ViewMediator vMdtr = ViewMediator.getGuiMediator();
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Dragged");
		vMdtr.mouseDragged(e);
		vMdtr.setCoordinates(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		vMdtr.setCoordinates(e);
	}
}
