package view;

import javax.swing.JButton;

import mediator.ViewMediator;

public class ButtonState extends JButton{
	ViewMediator mdtr = ViewMediator.getInstance();
	public ButtonState(String name){
		super(name);
		mdtr.registerButtonState(this);
	}
}
