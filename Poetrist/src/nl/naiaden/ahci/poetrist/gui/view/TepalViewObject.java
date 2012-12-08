/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import nl.naiaden.ahci.poetrist.gui.model.Tepal;

/**
 * 
 * @author louis
 * 
 */
public class TepalViewObject implements Observer {
	
	private Tepal tepal;
	private double xPosition;
	private double yPosition;
	
	private double height;
	private double width;
	
	private double rotation;

	public Tepal getTepal() {
		return tepal;
	}
	
	public TepalViewObject(Color colour, double xPos, double yPos)
	{
		this(new Tepal(colour), xPos, yPos);
	}
	
	public TepalViewObject(Tepal tepal, double xPos, double yPos)
	{
		this(tepal, xPos, yPos, 50, 20);
	}
	
	public TepalViewObject(Tepal tepal, double xPos, double yPos, double height, double width)
	{
		this(tepal, xPos, yPos, height, width, 0);
	}
	
	public TepalViewObject(Tepal tepal, double xPos, double yPos, double height, double width, double rotation)
	{
		this.tepal = tepal;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;
		this.rotation = rotation;
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(tepal.getColour());
		Shape shape = createPetal(100, (1.0 / (width / 2.0)) + 0.5);
		g2.fill(shape);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1.equals(tepal))
		{
			// it's for me!
		}
		
	}
	
	public Shape createPetal(double width, double percent)
	{
//System.out.println("numPetals:"+numPetals+" percent:"+percent);
	
		Shape shape;
		double dx, dy;
		Point2D p1 = new Point2D.Double();
		Point2D p2 = new Point2D.Double();
		
		dx = width * (1.0 - percent);
		dy = width * percent;
		p1.setLocation(xPosition + dx, yPosition + dy);
		dx = width * percent;
		dy = width * (1.0 - percent);
		p2.setLocation(xPosition + dx, yPosition + dy);		
		shape = createCubicCurve(new Point2D.Double(xPosition, yPosition), new Point2D.Double(xPosition, yPosition), p2, p1);
		
		
		Shape transformedShape;
		
		AffineTransform t = new AffineTransform();
		t.translate(xPosition, yPosition);
		t.rotate(rotation);
		t.translate(-xPosition, -yPosition);
		
		transformedShape = t.createTransformedShape(shape);
		
		return transformedShape;
	}

public Shape createCubicCurve(Point2D p0, Point2D p1, Point2D p2, Point2D p3)
{
	//Added checking for big integers (>1000000)
	//when antialiasing is on it causes an exception: 
	//sun.dc.pr.PRException: endPath: bad path 
	//(java bug http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4696289)
	if (p0.getY() >= 1000000 || 
		p1.getY() >= 1000000 || 
		p2.getY() >= 1000000 ||
		p3.getY() >= 1000000){
			
		return null;
	}
	//
	
	return new CubicCurve2D.Double(	(int)p0.getX(), (int)p0.getY(),
									(int)p2.getX(), (int)p2.getY(),
									(int)p3.getX(), (int)p3.getY(),
									(int)p1.getX(), (int)p1.getY());
}
}
