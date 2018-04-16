package strategy;

import java.awt.Color;

public class BlueColorStrategy implements ColorStrategy{

	private int r = 40;
	private int g = 40;
	private int b = 225;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}
