package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.Serializable;

public class State extends Component implements Serializable{
	private Rectangle b;
	private float line;
	
	public State() {
		super();
		setBoundary();
	}
	
	public State(String text, Point p) {
		this.attachSubject();
		setText(text);
		setPoint(p);
		setX(p.x);
		setY(p.y);
		setSize(60);
		line = 2;
		setBoundary();
	}
	
	@Override
	public String getClassName() {
		return "State";
	}

	@Override
	public void attachSubject() {
		mediator.attachStateSubject(this);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		
		((Graphics2D)g).setStroke(new BasicStroke(line));
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,		//�ϥΨ������ﵽ��ܽ�q
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawOval(b.x, b.y, b.width, b.height);		//�e��
		 
		g.drawString(getText(), (int)(getX()-getSize()/2), getY());						//�e��r(state�W��)
		
		g.setColor(new Color(0,0,0,0));								//�T���M�z����
		 
        g.drawRect(b.x, b.y, b.width, b.height);					//�e����d��A�����
        
	}
	
	public void setBoundary() {
		b = new Rectangle();
        b.setBounds((int)(getX() - getSize()), (int)(getY() - getSize()), (int)Math.round(2.0*getSize()), (int)Math.round(2.0*getSize()));
    }
	
	
	
	public boolean checkPoint(Point p) {		//�T�{�ƹ��I���B�O�_�b�Ϥ��d��
		return this.b.contains(p);
	}
	
	public boolean checkLinePoint(Point p) {return false;}

	@Override
	public void changePoint(Point p) {
		// TODO Auto-generated method stub
		setPoint(p);
		setBoundary();
	}
}
