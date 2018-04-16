package guiStrategy;

import java.awt.Color;

public class DarkUI implements GuiStrategy{

	@Override
	public Color changeButton() {
		// TODO Auto-generated method stub
		return new Color(96, 96, 96);
	}

	@Override
	public Color changePanel() {
		// TODO Auto-generated method stub
		return new Color(32, 32, 32);
	}

	@Override
	public Color changeButtonFont() {
		// TODO Auto-generated method stub
		return new Color(255, 255, 255);
	}

}
