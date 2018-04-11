package view;

import javax.swing.JButton;

import controller.MainMediator;

public class ButtonEdit extends JButton{
	MainMediator guiMdtr;
	public ButtonEdit(String name, MainMediator mdtr){
		super(name);
		this.guiMdtr = mdtr;
		mdtr.registerButtonEdit(this);
	}
}
