package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mediator.ViewMediator;

public class BtnStateListener implements ActionListener{
	private ViewMediator vMdtr = ViewMediator.getInstance();

	public BtnStateListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.stateClick(e);
	}

}
