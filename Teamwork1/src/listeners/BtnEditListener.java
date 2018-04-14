package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ViewMediator;

public class BtnEditListener implements ActionListener{

	private ViewMediator mainMtr;
	public BtnEditListener(ViewMediator mainMtr) {
		this.mainMtr = mainMtr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainMtr.btnEditClick(e);
	}
}
