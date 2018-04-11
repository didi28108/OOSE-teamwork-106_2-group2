package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MainMediator;

public class BtnTransListener implements ActionListener{

	private MainMediator mainMtr;
	
	public BtnTransListener(MainMediator mainMtr) {
		this.mainMtr = mainMtr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainMtr.btnTransClick(e);
	}
	
}
