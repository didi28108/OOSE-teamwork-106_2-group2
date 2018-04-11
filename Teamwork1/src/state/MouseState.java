package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.StateDiagram;

public interface MouseState {
	public MouseState mouseClicked(MouseEvent e, StateDiagram sd, MementoCaretaker ct);
}
