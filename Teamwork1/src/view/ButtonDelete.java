package view;

import javax.swing.JButton;

import controller.MainMediator;

public class ButtonDelete extends JButton{
	MainMediator guiMdtr;
	
	public ButtonDelete(String name, MainMediator mdtr){
		super(name);
		this.guiMdtr = mdtr;
		mdtr.registerButtonDelete(this);
	}
}
