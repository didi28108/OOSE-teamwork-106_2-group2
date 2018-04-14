package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import controller.ViewMediator;
import statediagram.Component;
import statediagram.State;
import statediagram.StateDiagram;
import statediagram.Transition;

public class DrawCanvas extends JPanel{
	ViewMediator mdtr = ViewMediator.getGuiMediator();
	private Component components;
	private float radius = 10;
	
	public DrawCanvas() {
		components = new StateDiagram();
		this.setBackground(Color.white);
		mdtr.registerDrawCanvas(this);
	}
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.black);
		components.draw(g);
	}
	
	public void addState(Point point) {
		// TODO Auto-generated method stub
		Component state = new State("testing", point);
		components.add(state);
		repaint();
	}
	public void addTrans(Point point, Component s1, Component s2) {
		// TODO Auto-generated method stub
		Component trans = new Transition("Line", s1, s2);
		components.add(trans);
		repaint();
	}
	public void changePoint(MouseEvent e, Component comp) {
		// TODO Auto-generated method stub
		comp.changePoint(e.getPoint());
		repaint();
	}
}
