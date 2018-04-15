package strategy;

import java.awt.Color;

public class YellowColorStrategy implements ColorStrategy{

	private int r = 255;
	private int g = 226;
	private int b = 17;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}