package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import guiStrategy.FlatUI;
import mediator.ViewMediator;

public class ChangeFlatUIStyleListener implements ActionListener{

	ViewMediator vMdtr = ViewMediator.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.changeGuiStrategy(new FlatUI());
	}

}
