import java.util.*;

class MementoCaretaker{
    private List<ObjectStatusMemento> HistoryStatus = new arrays<ObjectStatusMemento>();

    private static mediator Mediator{
    }

    public static void addMemento(ObjectStatusMemento memento){
        this.HistoryStatus.add(memento);
    }

    public static ObjectStatusMemento getMemento(){
        return this.HistoryStatus;
    }
}