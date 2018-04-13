package statediagram;

import mediator.Mediator;
import memento.ObjectStatusMemento;
import observer.Observer;
import observer.Subject;

import java.awt.Color;
import java.util.Date;


/**
 * Component
 * State, Transition, StateDiagram的上層物件
 */
public abstract class Component implements Observer {
    private int id;
    private int group;
    private Color color;
    private float size;
    private String text;
    //x, y值還不確定需不需要浮點數, 先用int
    private int x;
    private int y;
    protected Mediator mediator;

    public Component() {
        //以時間來當作ID
		Date now = new Date();
        this.id = now.hashCode();
        this.group = 0; //default 0
        this.mediator = Mediator.getInstance();
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getGroup() {
        return this.group;
    }
    public void setGroup(int group) {
        this.group = group;
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
        this.color = mediator.getColorFromFactory(color);
    }

    /**
     * 將目前的狀態存成一個Memento
     * @return Memento
     */
    public ObjectStatusMemento save() {
        return new ObjectStatusMemento(this.id, this.group, this.color, this.size, this.text, this.x, this.y);
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

    /**
     * do nothing
     */
    public Component getGroup(int group) {
        return null;
    }

    /**
     * 訂閱subject發來update訊息
     * @param subject =訂閱的subject
     */
    public void update(Subject subject) {
        this.changeColor(subject.getSubject());
    }
}
