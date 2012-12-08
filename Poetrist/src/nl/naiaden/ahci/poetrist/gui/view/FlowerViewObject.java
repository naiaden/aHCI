/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
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
	
	public Flower getFlower()
	{
		return flower;
	}
	
	/**
	 * 
	 */
	private List<TepalViewObject> tepals = null;
	
	private StigmaViewObject stigma = null;

	public FlowerViewObject(Flower flower, StigmaViewObject stigmaViewObject, double xPos, double yPos, double height, double width)
	{
		this.flower = flower;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;
		
		tepals = new ArrayList<TepalViewObject>();
		stigma = stigmaViewObject;
	}
	
	public FlowerViewObject(Flower flower, double xPos, double yPos, double height, double width)
	{
		this.flower = flower;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;
		
		tepals = new ArrayList<TepalViewObject>();
		stigma = new StigmaViewObject(flower.getStigma(), xPos, yPos, 2*width);
		
		flower.addObserver(this);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		
		Rectangle2D stem = new Rectangle2D.Double(xPosition-0.5*width, yPosition, width, height);
		g2.setColor(Color.GREEN);
		g2.fill(stem);
		
		for(TepalViewObject tepal : tepals)
		{
			tepal.paint(g);
		}
		
		stigma.paint(g);
		
		double radiusCentre = 75;
		double centreX = xPosition-0.5*radiusCentre;
		double centreCentreY = yPosition+height;
		
		
	}


	
	public void addTepal(TepalViewObject tepal)
	{
		if(flower.addTepal(tepal.getTepal()))
		{
			tepals.add(tepal);
		}
		
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
