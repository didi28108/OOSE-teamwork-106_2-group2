package view;

import javax.swing.JButton;

import controller.MainMediator;

public class ButtonTransition extends JButton{
	MainMediator guiMdtr;
	public ButtonTransition(String name, MainMediator mdtr){
		super(name);
		this.guiMdtr = mdtr;
		mdtr.registerButtonTransition(this);
	}
}
