package view;

import javax.swing.JButton;

import controller.ViewMediator;

public class ButtonEdit extends JButton{
	ViewMediator mdtr = ViewMediator.getGuiMediator();
	public ButtonEdit(String name){
		super(name);
		mdtr.registerButtonEdit(this);
	}
}
