package memento;

import statediagram.Component;
import java.util.*;

public class StateDiagramStatusMemento extends ObjectStatusMemento {
    private ArrayList<Component> componentList;

    public StateDiagramStatusMemento (int id, Color color, float size, String text,
        int x, int y, ArrayList<Component> componentList) {
        super(id, color, size, text, x, y);
        this.componentList = componentList;
    }

    public ArrayList<Component> getComponentList() {
        return this.componentList;
    }
}
