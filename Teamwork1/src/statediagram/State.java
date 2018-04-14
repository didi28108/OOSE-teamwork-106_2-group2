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
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,		//使用防鋸齒改善顯示質量
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawOval(b.x, b.y, b.width, b.height);		//畫圓
		 
		g.drawString(getText(), (int)(getX()-getSize()/2), getY());						//畫文字(state名稱)
		
		g.setColor(new Color(0,0,0,0));								//三原色和透明度
		 
        g.drawRect(b.x, b.y, b.width, b.height);					//畫選取範圍，正方形
        
	}
	
	public void setBoundary() {
		b = new Rectangle();
        b.setBounds((int)(getX() - getSize()), (int)(getY() - getSize()), (int)Math.round(2.0*getSize()), (int)Math.round(2.0*getSize()));
    }
	
	
	
	public boolean checkPoint(Point p) {		//確認滑鼠點擊處是否在圖片範圍內
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
