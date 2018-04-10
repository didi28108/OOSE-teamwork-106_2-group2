import java.util.*;

class ObjectStatusMemento{
    private int id;
    private Color color;
    private float size;
    private String text;
    private float x;
    private float y;

    public void ObjectStatusMemento(int id, Color color, float size, String text, float x, float y){
        ObjectStatusMemento memento = new ObjectStatusMemento();
        memento.id = id;
        memento.color = color;
        memento.size = size;
        memento.text = text;
        memento.x = x;
        memento.y = y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
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

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}