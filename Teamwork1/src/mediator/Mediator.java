package mediator;

import color.*;

public class Mediator {
    private ColorFactory colorFactory;
    public Color getColorFromFactory(String color) {
        return this.colorFactory.getColor(color);
    }
}
