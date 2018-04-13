package memento;

import mediator.Mediator;
import java.util.*;

public class MementoCaretaker{
    private ArrayList<ObjectStatusMemento> historyStatus;
    private int nowIndex;
    private Mediator mediator;

    public MementoCaretaker() {
        this.historyStatus = new ArrayList<ObjectStatusMemento>();
        this.nowIndex = -1;

        this.mediator = Mediator.getInstance();
    }

    public void addMemento(ObjectStatusMemento memento) {
        //將這個動作後的Memento清空
        for (int i = (this.historyStatus.size() - 1); i > this.nowIndex; i -= 1) {
            this.historyStatus.remove(i);
        }

        this.historyStatus.add(memento);
        this.nowIndex += 1;
    }

    private ObjectStatusMemento getMemento(int index) {
        return this.historyStatus.get(index);
    }

    /**
     * 回傳上一步的Memento, 不存在時會回傳最初的 (list[0])
     * @return 上一步的Memento
     */
    public ObjectStatusMemento undo() {
        if (this.nowIndex > 0) {
            this.nowIndex -= 1;
        }

        return this.getMemento(this.nowIndex);
    }

    /**
     * 回傳下一步的Memento, 不存在時會回傳現在的 (list[size()-1])
     * @return 下一步的Memento
     */
    public ObjectStatusMemento redo() {
        if (this.nowIndex < (this.historyStatus.size() - 1)) {
            this.nowIndex += 1;
        }

        return this.getMemento(this.nowIndex);
    }
}
