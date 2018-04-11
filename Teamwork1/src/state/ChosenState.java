package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.StateDiagram;

public class ChosenState implements MouseState{
	//singleton
	private static ChosenState instance = null;

	public ChosenState() {}

	public static ChosenState getInstance() {

		if (instance == null) {

			return new ChosenState();
		}

		return instance;

	}

	@Override
	public MouseState mouseClicked(MouseEvent e, StateDiagram sd, MementoCaretaker ct) {
		// TODO Auto-generated method stub
		return null;
	}
}
