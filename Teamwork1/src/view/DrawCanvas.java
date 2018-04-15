package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import controller.ViewMediator;
import listeners.MousePositionsListener;
import listeners.MyMouseListener;
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
		

		this.addMouseMotionListener(new MousePositionsListener());
		this.addMouseListener(new MyMouseListener());
	}
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.black);
		components.draw(g);
	}
	
}
