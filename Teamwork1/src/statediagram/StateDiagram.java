package statediagram;

import memento.ObjectStatusMemento;
import memento.StateDiagramStatusMemento;
import java.util.ArrayList;

import mediator.ViewMediator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.Error;

public class StateDiagram extends Component {
	private ArrayList<Component> componentList;
    private ViewMediator mdtr = ViewMediator.getInstance();
    
	public StateDiagram() {
		super();
		this.componentList = new ArrayList<Component>();
	}
	public StateDiagram(Color color) {
		super(color);
		this.componentList = new ArrayList<Component>();
	}
	
	public ArrayList<Component> getComponentList() {
		return componentList;
	}
	
	@Override
	public String getClassName() {
		return "StateDiagram";
	}

	@Override
	public void changeColor(String color) {
		super.changeColor(color);
		for (Component c: this.componentList) {
			c.changeColor(color);
		}
	}

	@Override
	public void attachSubject() {
		for (Component c: this.componentList) {
			c.attachSubject();
		}
	}
	
	@Override
	public ObjectStatusMemento save() {
		ArrayList<ObjectStatusMemento> saveList = new ArrayList<ObjectStatusMemento>();
		for (Component c: this.componentList) {
			saveList.add(c.save());
		}

		return new StateDiagramStatusMemento(this.getClassName(), this.getId(), this.getGroup(), this.getColor(),
			this.getSize(), this.getText(), this.getX(), this.getY(), this.getPoint(),
			saveList);
	}
	
	@Override
	/**
     * 使用Memento物件來恢復狀態
     * @param previousMemento =先前儲存的Memento
     */
	public void restore(ObjectStatusMemento previousMemento) {
		super.restore(previousMemento);

		this.componentList = new ArrayList<Component>();
		for (ObjectStatusMemento m: previousMemento.getComponentList()) {
			Component re;
			if (m.getClassName().equals("State")) {
				System.out.println("restore State");
				re = new State();
			}
			else if (m.getClassName().equals("Transition")) {
				System.out.println("restore Transition");
				re = new Transition();
			}
			else {
				re = new StateDiagram();
			}
			re.restore(m);
			this.componentList.add(re);
		}
	}

	
	@Override
	/**
	 * 將一個Component加進來
	 * @param newComponent =要加入的Component
	 */
	public void add(Component newComponent) {
		this.componentList.add(newComponent);
	}

	@Override
	/**
	 * 將符合id的Component從list移除
	 * @param id =要移除的component的id
	 */
	public void remove(int id) {
		this.componentList.remove(this.getComponent(id));
	}

	@Override
	/**
	 * 將符合id的Component回傳
	 * @param id =要尋找的component的id
	 */
	public Component getComponent(int id) {
		for (Component c: this.componentList) {
			if (c.getId() == id) {
				return c;
			}
			else {
				Component cc = c.getComponent(id);
				if (cc != null) {
					return cc;
				}
			}
		}

		return null;
	}
	
	@Override
	/**
	 * 回傳第一個找到的符合指定組別的Component
	 * @param group =目標的組別代碼
	 * @return 目標的組別 / 找不到時為null
	 */

	public Component getGroup(int group) {
		for (Component c: this.componentList) {
			if (c.getGroup() == group) {
				return c;
			}
		}

		return null;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for(Component c: this.componentList) {
			c.draw(g);
		}
	}
	
	public boolean checkPoint(Point p) {return false;}
	public boolean checkLinePoint(Point p) {return false;}
	public Point getPoint() {return null;}

	@Override
	public void changePoint(Point p) {
		// TODO Auto-generated method stub
		
	}
}
