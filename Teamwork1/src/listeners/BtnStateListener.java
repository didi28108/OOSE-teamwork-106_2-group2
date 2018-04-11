package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MainMediator;

public class BtnStateListener implements ActionListener{
	private MainMediator mainMtr;
	
	public BtnStateListener(MainMediator mainMtr) {
		this.mainMtr = mainMtr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainMtr.btnStateClick(e);
	}

}
