package view;

import javax.swing.JButton;

import mediator.ViewMediator;

public class ButtonTransition extends JButton{
	ViewMediator mdtr = ViewMediator.getInstance();
	public ButtonTransition(String name){
		super(name);
		mdtr.registerButtonTransition(this);
	}
}
