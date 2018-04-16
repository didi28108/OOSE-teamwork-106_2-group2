package memento;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Line2D;

import statediagram.Component;


public class TransitionStatusMemento extends ObjectStatusMemento {
    private Component s1;
	private Component s2;
	private Line2D line;

    public TransitionStatusMemento(String className, int id, int group,
            Color color, float size, String text, int x, int y, Point point,
            Component s1, Component s2, Line2D line) {
        super(className, id, group, color, size, text, x, y, point);
        this.s1 = s1;
        this.s2 = s2;
        this.line = line;
    }

    @Override
    public Component getS1() {
        return this.s1;
    }
    @Override
    public Component getS2() {
        return this.s2;
    }
    @Override
    public Line2D getLine2D() {
        return this.line;
    }
}
