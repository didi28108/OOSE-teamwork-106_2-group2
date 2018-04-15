package flyweight;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import strategy.*;

// Color Strategy is flyweight
public class ColorFactory {
	private HashMap<String, Color> ColorList = new HashMap<>();
	private Color result = null;
	private ArrayList<String> colorStringList = new ArrayList<String>();

	public ColorFactory() {
		this.colorStringList.add("Black");
		this.colorStringList.add("MikuGreen");
		this.colorStringList.add("Yellow");
		this.colorStringList.add("Pink");
		this.colorStringList.add("Red");
		this.colorStringList.add("Blue");
		this.colorStringList.add("Orange");
	}

	public ArrayList<String> getColorStringList() {
		return this.colorStringList;
	}

	public Color getColor(String color) {
		result = ColorList.get(color);

		if (result == null) {
			result = createNewColor(color);
			ColorList.put(color, result);
		}

		return result;
	}

	public Color createNewColor(String color) {
		ColorStrategy colorStrategy;
		switch (color.toLowerCase()) {
			case "black":
				colorStrategy = new BlackColorStrategy();
				break;
			case "mikugreen":
				colorStrategy = new MikuGreenColorStrategy();
				break;
			case "yellow":
				colorStrategy = new YellowColorStrategy();
				break;
			case "pink":
				colorStrategy = new PinkColorStrategy();
				break;
			case "red":
				colorStrategy = new RedColorStrategy();
				break;
			case "blue":
				colorStrategy = new BlueColorStrategy();
				break;
			case "orange":
				colorStrategy = new OrangeColorStrategy();
				break;
			default:
				colorStrategy = new BlackColorStrategy();
				break;
		}
		result = colorStrategy.handle();

		return result;
	}
}
