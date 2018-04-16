package statediagram;

import memento.ObjectStatusMemento;
import observer.Observer;
import observer.Subject;
import strategy.ColorStrategy;
import mediator.ModelMediator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
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
    private Point point;
    
    protected ModelMediator mediator;


    public Component() {
        //以時間來當作ID
		Date now = new Date();
        this.id = now.hashCode();
        this.group = 1; //default 0
        this.mediator = ModelMediator.getInstance();
        this.setColor(mediator.getColorFromFactory("black"));
    }
    public Component(Color color) {
        //以時間來當作ID
		Date now = new Date();
        this.id = now.hashCode();
        this.group = 1; //default 0
        this.setColor(color);   
    }


    public abstract String getClassName();
    
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

    public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point p) {
		this.point = p;
    }
    
    public Component getS1() {
        return null;
    }
    public Component getS2() {
        return null;
    }
    public void setS1(Component s1) {
    }
    public void setS2(Component s2) {
    }
    
    /**
     * 透過輸入指定顏色(ex: "red")來改變顏色
     * @param color =指定的顏色
     */
    public void changeColor(String color) {
    	System.out.println("component.changeColor  :" + color);
        this.setColor(mediator.getColorFromFactory(color));
    }

    /**
     * 將目前的狀態存成一個Memento
     * @return Memento
     */
    public ObjectStatusMemento save() {
        return new ObjectStatusMemento(this.getClassName(), this.id, this.group,
            this.color, this.size, this.text, this.x, this.y, this.point);
    }
    /**
     * 使用Memento物件來恢復狀態
     * @param previousMemento =先前儲存的Memento
     */
    public void restore(ObjectStatusMemento previousMemento) {
        this.id = previousMemento.getId();

        this.group = previousMemento.getGroup();
        this.color = previousMemento.getColor();
        this.size = previousMemento.getSize();
        this.text = previousMemento.getText();
        this.x = previousMemento.getX();
        this.y = previousMemento.getY();
        this.point = previousMemento.getPoint();
    }
    public void fixTransitionRelationship() {
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
    public ArrayList<Component> getComponentList() {
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

    /**
     * 訂閱特定Subject
     */
    public abstract void attachSubject();
    
    public abstract void draw(Graphics g);
	public abstract boolean checkPoint(Point p);					//為了分辨是使用line還是State，這是State
	public abstract boolean checkLinePoint(Point p);				//使用line
	public abstract void changePoint(Point p);
}