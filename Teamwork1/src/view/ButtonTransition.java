package view;

import javax.swing.JButton;

import controller.ViewMediator;

public class ButtonTransition extends JButton{
	ViewMediator mdtr = ViewMediator.getGuiMediator();
	public ButtonTransition(String name){
		super(name);
		mdtr.registerButtonTransition(this);
	}
}
