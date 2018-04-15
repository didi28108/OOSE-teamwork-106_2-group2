package memento;

import java.awt.Color;
import java.util.*;


public class StateDiagramStatusMemento extends ObjectStatusMemento {
    private ArrayList<ObjectStatusMemento> componentList;

    public StateDiagramStatusMemento (String className, int id, int group, Color color, float size, String text,
        int x, int y, ArrayList<ObjectStatusMemento> componentList) {
        super(className, id, group, color, size, text, x, y);
        this.componentList = componentList;
    }

    @Override
    public ArrayList<ObjectStatusMemento> getComponentList() {
        return this.componentList;
    }
}