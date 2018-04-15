package view;

import javax.swing.JButton;

import mediator.ViewMediator;

public class ButtonSelect extends JButton{
	ViewMediator mdtr = ViewMediator.getInstance();
	public ButtonSelect(String name){
		super(name);
		mdtr.registerButtonSelect(this);
	}
}
