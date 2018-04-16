package memento;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;


public class StateStatusMemento extends ObjectStatusMemento {
    private Rectangle b;
	private float line;

    public StateStatusMemento(String className, int id, int group,
            Color color, float size, String text, int x, int y, Point point, Rectangle b, float line) {
        super(className, id, group, color, size, text, x, y, point);
        this.b = b;
        this.line = line;
    }

    @Override
    public Rectangle getB() {
        return this.b;
    }
    @Override
    public float getLine() {
        return this.line;
    }
}
