package statediagram;

import mediator.Mediator;
import memento.ObjectStatusMemento;

import java.awt.Color;
import java.util.Date;

import flyweight.ColorFactory;

/**
 * Component
 * State, Transition, StateDiagram的上層物件
 */
public abstract class Component {
    private int id;
    private Color color;
    private float size;
    private String text;
    //x, y值還不確定需不需要浮點數, 先用int
    private int x;
    private int y;
    private Mediator mediator;
    private ColorFactory colorFactory;

    public Component() {
        //以時間來當作ID
		Date now = new Date();
        this.id = now.hashCode();
        this.mediator = new Mediator();
        this.colorFactory = new ColorFactory();
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public float getSize() {
        return this.size;
    }
    public void setSize(float size) {
        this.size = size;
    }

    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 透過輸入指定顏色(ex: "red")來改變顏色
     * @param color =指定的顏色
     */
    public void changeColor(String color) {
        this.color = colorFactory.getColor(color);
    }

    /**
     * 將目前的狀態存成一個Memento
     * @return Memento
     */
    public ObjectStatusMemento save() {
        return new ObjectStatusMemento(this.id, this.color, this.size, this.text, this.x, this.y);
    }
    /**
     * 使用Memento物件來恢復狀態
     * @param previousMemento =先前儲存的Memento
     */
    public void restore(ObjectStatusMemento previousMemento) {
        this.id = previousMemento.getId();
        this.color = previousMemento.getColor();
        this.size = previousMemento.getSize();
        this.text = previousMemento.getText();
        this.x = previousMemento.getX();
        this.y = previousMemento.getY();
    }

    /**
     * do nothing
     */
    public void add(Component newComponent) {}
    /**
     * do nothing
     */
    public void remove(int id) {}

    /**
     * do nothing
     */
    public Component getComponent(int id) {
        return null;
    }
}
