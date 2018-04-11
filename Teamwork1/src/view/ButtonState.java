package view;

import javax.swing.JButton;

import controller.MainMediator;

public class ButtonState extends JButton{
	MainMediator guiMdtr;
	public ButtonState(String name, MainMediator mdtr){
		super(name);
		this.guiMdtr = mdtr;
		mdtr.registerButtonState(this);
	}
}
