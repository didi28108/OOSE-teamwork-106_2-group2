package memento;

import mediator.Mediator;
import java.util.*;

public class MementoCaretaker{
    private ArrayList<ObjectStatusMemento> historyStatus = new ArrayList<ObjectStatusMemento>();

    private Mediator mediator;

    public void addMemento(ObjectStatusMemento memento) {
        this.historyStatus.add(memento);
    }

    public ObjectStatusMemento getMemento() {
        ObjectStatusMemento re = this.historyStatus.get(this.historyStatus.size() - 1);
        this.historyStatus.remove(re);
        return re;
    }
}
