package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.ViewMediator;
import state.MouseState;

public class MyMouseListener implements MouseListener{
	private ViewMediator mdtr;
	private MouseState mouseState;
	public MyMouseListener(ViewMediator mdtr) {
		this.mdtr = mdtr;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		mdtr.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed");
		mdtr.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Releadsed");
		mdtr.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
