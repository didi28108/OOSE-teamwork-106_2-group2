package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.StateDiagram;

public class ChosenSelect implements MouseState{
	//singleton
	private static ChosenSelect instance = null;

	public ChosenSelect() {}

	public static ChosenSelect getInstance() {

		if (instance == null) {

			return new ChosenSelect();
		}

		return instance;

	}

	@Override
	public MouseState mouseClicked(MouseEvent e, StateDiagram sd, MementoCaretaker ct) {
		// TODO Auto-generated method stub
		return null;
	}
}
