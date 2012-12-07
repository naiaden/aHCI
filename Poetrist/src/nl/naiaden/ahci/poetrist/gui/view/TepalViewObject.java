/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
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
		this.tepal = tepal;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		System.out.println("[TepalView] Another tepal!");

		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D.Double petal1 = new Ellipse2D.Double(xPosition, yPosition, 35, 35);
		g2.setColor(tepal.getColour());
		g2.fill(petal1);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1.equals(tepal))
		{
			// it's for me!
		}
		
	}
}
