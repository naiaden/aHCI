/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import nl.naiaden.ahci.poetrist.gui.model.Stigma;

/**
 * This class is a representation of the stigma.
 * 
 * @author louis
 * 
 */
public class StigmaViewObject implements FlowerPartViewObject
{
	private boolean isSelected = false;

	private double radius;
	private Stigma stigma;
	private double xPosition;

	private double yPosition;

	/**
	 * Creates a representation of the stigma.
	 * 
	 * @param stigma
	 *            The stigma.
	 * @param xPos
	 *            The x position of the centre of the stigma.
	 * @param yPos
	 *            The y position of the centre of the stigma.
	 * @param radius
	 *            The radius of the stigma. (We assume stigmata are round)
	 */
	public StigmaViewObject(Stigma stigma, double xPos, double yPos, double radius)
	{
		this.stigma = stigma;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.radius = radius;
	}

	@Override
	public Shape getShape()
	{
		return new Ellipse2D.Double(xPosition - 0.5 * radius, yPosition - radius / 2, radius, radius);
	}

	/**
	 * Returns the radius of the stigma. Stigmata are assumed to be circular.
	 * 
	 * @return the radius of the stigma.
	 */
	public double getRadius()
	{
		return radius;
	}

	/**
	 * Returns the stigma.
	 * 
	 * @return the stigma.
	 */
	public Stigma getStigma()
	{
		return stigma;
	}

	@Override
	public boolean isSelected()
	{
		return isSelected;
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(stigma.getColour());
		g2.fill(getShape());

		if (isSelected)
		{
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.BLACK);
			g2.draw(getShape());
		}
	}

	@Override
	public boolean positionInShape(Point2D position)
	{
		return getShape().contains(position);
	}

	@Override
	public void setSelected(boolean selected)
	{
		isSelected = selected;
	}

	@Override
	public boolean setSelectedIfInPosition(Point2D position)
	{
		setSelected(positionInShape(position));
		return isSelected;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String toString()
	{
		return "Stigma with colour: " + getStigma().getColour();
	}

}
