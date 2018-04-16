package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.Serializable;

import memento.ObjectStatusMemento;
import memento.StateStatusMemento;;

public class State extends Component implements Serializable{
	private Rectangle b;
	private float line;
	
	public State() {
		setBoundary();
		this.attachSubject();
	}
	
	public State(String text, Point p) {
		this.attachSubject();
		setText(text);
		setPoint(p);
		setX(p.x);
		setY(p.y);
		setSize(50);
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
		g.setColor(getColor());
		FontMetrics fm = g.getFontMetrics();
		double textWidth = fm.getStringBounds(getText(), g).getWidth();
		
		((Graphics2D)g).setStroke(new BasicStroke(line));
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,		//�ϥΨ������ﵽ��ܽ�q
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawOval(b.x, b.y, b.width, b.height);		//�e��
		 
		g.drawString(getText(), (int)(b.getCenterX()-textWidth/2), (int)(b.getCenterY() + fm.getMaxAscent() /2));//�e��ron middle
		
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

	public void setCenteredText(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, x, y);
	}
	
	@Override
	public void changePoint(Point p) {
		// TODO Auto-generated method stub
		this.setPoint(p);
		this.setX((int)p.getX());
		this.setY((int)p.getY());
		setBoundary();
	}

	@Override
	public ObjectStatusMemento save() {
        return new StateStatusMemento(this.getClassName(), this.getId(), this.getGroup(), this.getColor(),
				this.getSize(), this.getText(), this.getX(), this.getY(), this.getPoint(),
				this.b, this.line);
	}
	@Override
	public void restore(ObjectStatusMemento previousMemento) {
		super.restore(previousMemento);
		this.b = previousMemento.getB();
		this.line = previousMemento.getLine();
	}
}
