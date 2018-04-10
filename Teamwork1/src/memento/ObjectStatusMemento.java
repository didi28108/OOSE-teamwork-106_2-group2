package memento;

import color.Color;
import java.util.*;

public class ObjectStatusMemento{
    private int id;
    private Color color;
    private float size;
    private String text;
    private int x;
    private int y;

    public ObjectStatusMemento(int id, Color color, float size, String text, int x, int y){
        this.id = id;
        this.color = color;
        this.size = size;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public int getId(){
        return this.id;
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
}
