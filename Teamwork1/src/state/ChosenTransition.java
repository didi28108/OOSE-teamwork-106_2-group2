package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.StateDiagram;

public class ChosenTransition implements MouseState{
	//singleton
	private static ChosenTransition instance = null;

	public ChosenTransition() {}

	public static ChosenTransition getInstance() {

		if (instance == null) {

			return new ChosenTransition();
		}

		return instance;

	}

	@Override
	public MouseState mouseClicked(MouseEvent e, StateDiagram sd, MementoCaretaker ct) {
		// TODO Auto-generated method stub
		return null;
	}
}
