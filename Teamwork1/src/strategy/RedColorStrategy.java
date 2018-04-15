package strategy;

import java.awt.Color;

public class RedColorStrategy implements ColorStrategy{

	private int r = 240;
	private int g = 40;
	private int b = 40;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}
