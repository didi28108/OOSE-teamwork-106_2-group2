package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.io.Serializable;


public class Transition extends Component implements Serializable{
	
	private String name;
	private Component s1;		//起始點(StateDiagram(State)才有用到)，為了讓State變更時跟著變更
	private Component s2;		//結束點
	private Line2D line;			//線的範圍
	
	public Transition() {
		super();
		this.attachSubject();
	}
	
	public Transition(String name, Component s1, Component s2) {
		super();
		this.attachSubject();
		this.name = name;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void draw(Graphics g) {	
		
		Point p1 = s1.getPoint();
		Point p2 = s2.getPoint();
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1));							//線的粗細
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);		//使用防鋸齒改善顯示質量
  
        g2.setPaint(Color.black);
        
        double x;													//將角度轉成夾度再進行計算，p1和p2計算相反，取最短距離
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
        g2.drawString(name, xm, ym);		//線的名稱
        
	}
	
	public void drawArrow(Graphics2D g2, double x, double y)		//畫箭頭，兩條線
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

	public double getangles()		//計算兩點之間角度
	{
		Point p1 = s1.getPoint();
		Point p2 = s2.getPoint();
		
	    double x = p2.x - p1.x;
	    double y = p2.y - p1.y;    
	    double z = Math.sqrt(x * x + y * y);	    
	    double angle = (Math.asin(y / z) / Math.PI * 180);

	    return angle;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
public boolean checkPoint(Point p) {return false;}
	
	public boolean checkLinePoint(Point p) {
		return this.line.intersects(p.getX(), p.getY(), 5, 5);		//寬,高
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

}
