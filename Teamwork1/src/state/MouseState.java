package state;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import controller.ViewMediator;
import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.StateDiagram;

public interface MouseState {

	public void mousePressed(ViewMediator vMdtr, MouseEvent e);
	public void mouseReleased(ViewMediator vMdtr, MouseEvent e);
	//public void mouseReleased(MouseEvent e, DrawDiagram d, AbstractFactory f, Caretaker c);
	public void mouseDragged(ViewMediator vMdtr, MouseEvent e);
	public void mouseClicked(ViewMediator vMdtr, MouseEvent e);
}

