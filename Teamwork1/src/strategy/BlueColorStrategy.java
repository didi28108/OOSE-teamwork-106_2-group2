package strategy;

import java.awt.Color;

public class BlueColorStrategy implements ColorStrategy{

	private int r = 62;
	private int g = 190;
	private int b = 211;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}
