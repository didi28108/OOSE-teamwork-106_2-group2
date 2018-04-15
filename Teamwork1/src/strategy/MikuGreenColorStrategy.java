package strategy;

import java.awt.Color;

public class MikuGreenColorStrategy implements ColorStrategy{

	private int r = 57;
	private int g = 197;
	private int b = 187;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}