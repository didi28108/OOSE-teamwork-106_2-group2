package memento;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.*;

import statediagram.Component;


public class ObjectStatusMemento{
    private String className;
    private int id;
    private int group;
    private Color color;
    private float size;
    private String text;
    private int x;
    private int y;
    private Point point;

    public ObjectStatusMemento(String className, int id, int group,
            Color color, float size, String text, int x, int y, Point p) {
        this.className = className;
        this.id = id;
        this.group = group;
        this.color = color;
        this.size = size;
        this.text = text;
        this.x = x;
        this.y = y;
        this.point = p;
    }

    public String getClassName() {
        return this.className;
    }

    public int getId(){
        return this.id;
    }

    public int getGroup() {
        return this.group;
    }

    public Color getColor() {
        return this.color;
    }

    public String getText() {
        return this.text;
    }

    public float getSize() {
        return this.size;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Point getPoint() {
        return this.point;
    }


    public ArrayList<ObjectStatusMemento> getComponentList() {
        return null;
    }
    public Rectangle getB() {
        return null;
    }
    public float getLine() {
        return 0;
    }
    public Component getS1() {
        return null;
    }
    public Component getS2() {
        return null;
    }
    public Line2D getLine2D() {
        return null;
    }
}
