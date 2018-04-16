package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.io.Serializable;

import memento.TransitionStatusMemento;
import memento.ObjectStatusMemento;


public class Transition extends Component implements Serializable{
	
	private Component s1;		//�_�l�I(StateDiagram(State)�~���Ψ�)�A���F��State�ܧ�ɸ���ܧ�
	private Component s2;		//�����I
	private Line2D line;			//�u���d��
	
	public Transition() {
		super();
		this.attachSubject();
	}
	
	public Transition(String text, Component s1, Component s2) {
		super();
		this.attachSubject();
		this.setText(text);
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public Component getS1() {
		return this.s1;
	}
	@Override
	public Component getS2() {
		return this.s2;
	}
	@Override
	public void setS1(Component s1) {
		this.s1 = s1;
	}
	@Override
	public void setS2(Component s2) {
		this.s2 = s2;
	}
	
	@Override
	public void draw(Graphics g) {	
		
		Point p1 = s1.getPoint();
		Point p2 = s2.getPoint();
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));							//�u���ʲ�
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);		//�ϥΨ������ﵽ��ܽ�q
  
        g2.setPaint(getColor());
        
        double x;													//�N�����ন���צA�i��p��Ap1�Mp2�p��ۤϡA���̵u�Z��
        double y = p1.y + 30 *  Math.sin(Math.toRadians(getangles()));		
        double x2;
        double y2 = p2.y - 30 *  Math.sin(Math.toRadians(getangles()));
        
        if(p1.x < p2.x) {
        	x = p1.x + 30 *  Math.cos(Math.toRadians(getangles()));
        	x2 = p2.x - 30 *  Math.cos(Math.toRadians(getangles()));
        	drawArrow(g2, x2, y2);
        }
        else {
        	x = p1.x - 30 *  Math.cos(Math.toRadians(getangles()));
        	x2 = p2.x + 30 *  Math.cos(Math.toRadians(getangles()));
        	drawArrow(g2, x2, y2);
        }
        
        line = new Line2D.Double(x, y, x2, y2); 
        g2.draw(line);
        
        int xm = (int)((x + x2) / 2);
        int ym = (int)((y + y2) / 2);
        g2.setPaint(Color.black);
        g2.drawString(this.getText(), xm, ym);		//�u���W��
        
	}
	
	public void drawArrow(Graphics2D g2, double x, double y)		//�e�b�Y�A����u
    {
		Point p1 = s1.getPoint();
		Point p2 = s2.getPoint();
		
		double x2;
		double x3;
        double y2 = y + 20 * Math.sin(Math.toRadians(-getangles() + 25));
        double y3 = y + 20 * Math.sin(Math.toRadians(-getangles() - 25));
        
        if(p1.x > p2.x) {
        	x2 = x + 20 * Math.cos(Math.toRadians(-getangles() + 25));
        	x3 = x + 20 * Math.cos(Math.toRadians(-getangles() - 25));
        }
        else {
        	x2 = x - 20 * Math.cos(Math.toRadians(-getangles() + 25));
        	x3 = x - 20 * Math.cos(Math.toRadians(-getangles() - 25));
        }
        
        g2.draw(new Line2D.Double(x, y, x2, y2));   
        g2.draw(new Line2D.Double(x, y, x3, y3));
    }

	public double getangles()		//�p����I��������
	{
		Point p1 = s1.getPoint();
		Point p2 = s2.getPoint();
		
	    double x = p2.x - p1.x;
	    double y = p2.y - p1.y;    
	    double z = Math.sqrt(x * x + y * y);	    
	    double angle = (Math.asin(y / z) / Math.PI * 180);

	    return angle;
	}
	
	
	public boolean checkPoint(Point p) {return false;}
	
	public boolean checkLinePoint(Point p) {
		return this.line.intersects(p.getX(), p.getY(), 10, 10);		//�e,��
	}
	
	public Point getPoint() {return null;}
	public void ChangePoint(Point p) {}
	
	public String getType() {
		return "trans";
	}
	
	public Object clone(){
		Component de = null;
		try {
			de = (Component) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return de;
	}
	public boolean checkDiagramElement1(Component s1) {
		return this.s1 == s1;
	}
	
	public boolean checkDiagramElement2(Component s2) {
		return this.s2 == s2;
	}
	

	@Override
	public String getClassName() {
		return "Transition";
	}

	@Override
	public void attachSubject() {
		mediator.attachTransitionSubject(this);
	}

	@Override
	public void changePoint(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObjectStatusMemento save() {
        return new TransitionStatusMemento(this.getClassName(), this.getId(), this.getGroup(), this.getColor(),
				this.getSize(), this.getText(), this.getX(), this.getY(), this.getPoint(),
				this.s1, this.s2, this.line);
	}
	@Override
	public void restore(ObjectStatusMemento previousMemento) {
		super.restore(previousMemento);
		this.s1 = previousMemento.getS1();
		this.s2 = previousMemento.getS2();
		this.line = previousMemento.getLine2D();
	}
}
