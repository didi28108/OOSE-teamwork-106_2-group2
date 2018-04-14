package view;

import javax.swing.JButton;

import controller.ViewMediator;

public class ButtonSelect extends JButton{
	ViewMediator mdtr = ViewMediator.getGuiMediator();
	public ButtonSelect(String name){
		super(name);
		mdtr.registerButtonSelect(this);
	}
}
