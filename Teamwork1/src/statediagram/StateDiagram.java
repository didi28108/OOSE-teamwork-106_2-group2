package statediagram;

import memento.ObjectStatusMemento;
import memento.StateDiagramStatusMemento;
import java.util.ArrayList;
import java.lang.Error;

public class StateDiagram extends Component {
	private ArrayList<Component> componentList;

	public StateDiagram() {
		super();
		this.componentList = new ArrayList<Component>();
	}

	@Override
	public void changeColor(String color) {
		for (Component c: this.componentList) {
			c.changeColor(color);
		}
	}

	@Override
	public ObjectStatusMemento save() {
		return new StateDiagramStatusMemento(this.getId(), this.getColor(), this.getSize(), this.getText(),
			this.getX(), this.getY(), this.componentList);
	}
	
	@Override
	/**
     * StateDiagram can not restore with ObjectStatusMemento
	 * please use restore(StateDiagramStatusMemento previousMemento)
     * @param previousMemento =先前儲存的Memento
     */
	public void restore(ObjectStatusMemento previousMemento) {
		throw new Error("StateDiagram can not restore with ObjectStatusMemento");
	}

	/**
     * 使用Memento物件來恢復狀態
     * @param previousMemento =先前儲存的Memento
     */
	public void restore(StateDiagramStatusMemento previousMemento) {
        this.setId(previousMemento.getId());
        this.setColor(previousMemento.getColor());
        this.setSize(previousMemento.getSize());
        this.setText(previousMemento.getText());
        this.setX(previousMemento.getX());
		this.setY(previousMemento.getY());
		this.componentList = previousMemento.getComponentList();
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
		Component reC = null;
		for (Component c: this.componentList) {
			if (c.getId() == id) {
				reC = c;
				break;
			}
		}

		return reC;
	}
}
