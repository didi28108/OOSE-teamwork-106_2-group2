package flyweight;

import java.awt.Color;
import java.util.HashMap;

import strategy.BlackColorStrategy;
import strategy.ColorStrategy;

// Color Strategy is flyweight
public class ColorFactory {
	private HashMap<String,Color> ColorList = new HashMap<>();
	private ColorStrategy colorStrategy;
	private Color result = null;
	
	
//	private Mediator mediator = new Mediator();
//	
//	public ColorFactory(Mediator mediator) {
//		this.mediator = mediator;
//	}
	
	
	public Color getColor(String color) {
		result = ColorList.get(color);
		
		if(result == null) {
			result = createNewColor(color);
			ColorList.put(color, result);
		}
		
		return result;
	}
	
	public Color createNewColor(String color) {
		colorStrategy = new BlackColorStrategy();
		if(color.toLowerCase().equals("black")) {
			result = colorStrategy.handle();
		}else if(color.toLowerCase().equals("red")) {
			result = colorStrategy.handle();
		}
		
		return result;
	}
}
