package view;

import javax.swing.JButton;

import controller.MainMediator;

public class ButtonSelect extends JButton{
	MainMediator guiMdtr;
	public ButtonSelect(String name, MainMediator mdtr){
		super(name);
		this.guiMdtr = mdtr;
		mdtr.registerButtonSelect(this);
	}
}
