package view;

import javax.swing.JButton;

import mediator.ViewMediator;

public class ButtonDelete extends JButton{
	ViewMediator mdtr = ViewMediator.getInstance();
	
	public ButtonDelete(String name){
		super(name);
		mdtr.registerButtonDelete(this);
	}
}
