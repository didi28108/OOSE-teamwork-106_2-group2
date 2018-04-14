package view;

import javax.swing.JButton;

import controller.ViewMediator;

public class ButtonDelete extends JButton{
	ViewMediator mdtr = ViewMediator.getGuiMediator();
	
	public ButtonDelete(String name){
		super(name);
		mdtr.registerButtonDelete(this);
	}
}
