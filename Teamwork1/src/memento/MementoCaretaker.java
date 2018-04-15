package memento;

import mediator.ModelMediator;
import java.util.*;

public class MementoCaretaker{
    private ArrayList<ObjectStatusMemento> historyStatus;
    private int nowIndex;
    private ModelMediator mediator;

    public MementoCaretaker() {
        this.historyStatus = new ArrayList<ObjectStatusMemento>();
        this.nowIndex = -1;

        this.mediator = ModelMediator.getInstance();
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

    public boolean canUndo() {
        if (this.nowIndex > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * 回傳上一步的Memento, 不存在時會回傳最初的 (list[0])
     * @return 上一步的Memento
     */
    public ObjectStatusMemento undo() {
        if (this.canUndo()) {
            this.nowIndex -= 1;
        }

        return this.getMemento(this.nowIndex);
    }


    public boolean canRedo() {
        if (this.nowIndex < (this.historyStatus.size() - 1)) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * 回傳下一步的Memento, 不存在時會回傳現在的 (list[size()-1])
     * @return 下一步的Memento
     */
    public ObjectStatusMemento redo() {
        if (this.canRedo()) {
            this.nowIndex += 1;
        }

        return this.getMemento(this.nowIndex);
    }
}
