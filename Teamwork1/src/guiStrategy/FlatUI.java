package guiStrategy;

import java.awt.Color;

public class FlatUI implements GuiStrategy{

	
	@Override
	public Color changeButton() {
		// TODO Auto-generated method stub
		return new Color(52, 73, 94);
	}

	@Override
	public Color changePanel() {
		// TODO Auto-generated method stub
		return new Color(189, 195, 199);
	}}
