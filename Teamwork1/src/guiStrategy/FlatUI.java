package guiStrategy;

import java.awt.Color;

import mediator.ViewMediator;

public class FlatUI implements GuiStrategy{

	ViewMediator vMdtr = ViewMediator.getInstance();
	
	@Override
	public Color changeButton() {
		// TODO Auto-generated method stub
		return new Color(52, 73, 94);
	}

	public Color changeButtonFont() {
		return new Color(255, 255, 255);
	}
	
	@Override
	public Color changePanel() {
		// TODO Auto-generated method stub
		return new Color(189, 195, 199);
	}}
