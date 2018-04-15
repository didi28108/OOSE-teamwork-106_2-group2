package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ViewMediator;

public class BtnDeleteListener implements ActionListener{

	private ViewMediator vMdtr = ViewMediator.getGuiMediator();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.deleteClick(e);
	}

}
