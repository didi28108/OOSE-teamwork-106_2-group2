package view;

import javax.swing.JButton;

import mediator.ViewMediator;

public class ButtonEdit extends JButton{
	ViewMediator mdtr = ViewMediator.getInstance();
	public ButtonEdit(String name){
		super(name);
		mdtr.registerButtonEdit(this);
	}
}
