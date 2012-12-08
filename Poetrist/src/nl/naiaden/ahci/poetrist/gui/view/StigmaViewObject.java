/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import nl.naiaden.ahci.poetrist.gui.model.Stigma;

/**
 * 
 * @author louis
 *
 */
public class StigmaViewObject implements Observer
{
	private Stigma stigma;
	private double xPosition;
	private double yPosition;
	
	private double radius;
	
	public Stigma getStigma()
	{
		return stigma;
	}
	
	public StigmaViewObject(Color colour, double xPos, double yPos)
	{
		this(new Stigma(colour), xPos, yPos);
	}
	
	public StigmaViewObject(Stigma stigma, double xPos, double yPos)
	{
		this(stigma, xPos, yPos, 20);
	}
	
	public StigmaViewObject(Stigma stigma, double xPos, double yPos, double radius)
	{
		this.stigma = stigma;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.radius = radius;
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(stigma.getColour());
		
		Ellipse2D.Double stigmaShape = new Ellipse2D.Double(xPosition-0.5*radius, yPosition-radius/2, radius, radius);
		g2.fill(stigmaShape);
	}
	
	@Override
	public void update(Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub
		
	}
}
