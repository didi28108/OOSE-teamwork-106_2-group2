package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mediator.ViewMediator;

public class RedoListener implements ActionListener{
	
	private ViewMediator vMdtr = ViewMediator.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vMdtr.redoClick(e);
	}

}
