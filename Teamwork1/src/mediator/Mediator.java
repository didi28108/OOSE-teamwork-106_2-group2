package mediator;

import java.util.ArrayList;

import flyweight.*;
import model.ColorFactory;
import model.Component;
import model.MementorCaretaker;
import model.StateSubject;
import model.TransitionSubject;
import strategy.Strategy;
import view.StateDiagramEditor;

//I think this mediator is over

public class Mediator {
	StateDiagramEditor gui = new StateDiagramEditor();
	MementorCaretaker mementorCaretaker = new MementorCaretaker();
	ArrayList<Component> componentList = new ArrayList<Component>();
	StateSubject stateSubject = new StateSubject();
	TransitionSubject transitionSubject = new TransitionSubject();
	Strategy strategy = new Strategy();
    private ColorFactory colorFactory;
    public Color getColorFromFactory(String color) {
        return this.colorFactory.getColor(color);
    }
}
