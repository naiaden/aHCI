/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import nl.naiaden.ahci.poetrist.gui.model.Flower;

/**
 * 
 * @author louis
 * 
 */
public class FlowerViewObject implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5700516487959997920L;
	
	private Flower flower;
	private double xPosition;
	private double yPosition;
	
	private double height;
	private double width;
	
	/**
	 * 
	 */
	private List<TepalViewObject> tepals = null;

	public FlowerViewObject()
	{
		this(new Flower());
	}
	
	public FlowerViewObject(int numberOfTepals)
	{
		this(new Flower(numberOfTepals));
	}
	
	public FlowerViewObject(Flower flower)
	{
		this(flower, 0, 0);
	}
	
	public FlowerViewObject(Flower flower, double xPos, double yPos)
	{
		this(flower, xPos, yPos, 150, 25);
	}
	
	public FlowerViewObject(Flower flower, double xPos, double yPos, double height, double width)
	{
		this.flower = flower;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;
		
		tepals = new ArrayList<TepalViewObject>();
		
		flower.addObserver(this);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		System.out.println("[FlowerView] WOOEI (" + flower.getTepals().size() + ")");

		Graphics2D g2 = (Graphics2D) g;


		
		Rectangle2D stem = new Rectangle2D.Double(xPosition-0.5*width, yPosition, width, height);
		g2.setColor(Color.GREEN);
		g2.fill(stem);
		
		for(TepalViewObject tepal : tepals)
		{
			tepal.paint(g);
		}
		
		double radiusCentre = 75;
		double centreX = xPosition-0.5*radiusCentre;
		double centreCentreY = yPosition+height;
		
		Ellipse2D.Double flower=new Ellipse2D.Double(centreX,centreCentreY-radiusCentre/2,radiusCentre,radiusCentre);
		g2.setColor(Color.YELLOW);
		g2.fill(flower);
		
	}

	public void addTepal(TepalViewObject tepal)
	{
		tepals.add(tepal);
	}
	
	@Override
	public void update(Observable o, Object arg) {
//		if(arg.equals(flower))
		if(arg == flower)
		{
			System.out.println("NICE!");
		}
		
	}
}
