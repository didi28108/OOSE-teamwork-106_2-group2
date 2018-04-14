package view;

import javax.swing.JButton;

import controller.ViewMediator;

public class ButtonState extends JButton{
	ViewMediator mdtr = ViewMediator.getGuiMediator();
	public ButtonState(String name){
		super(name);
		mdtr.registerButtonState(this);
	}
}
