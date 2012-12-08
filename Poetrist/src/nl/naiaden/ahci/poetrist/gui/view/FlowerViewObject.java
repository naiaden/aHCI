/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import nl.naiaden.ahci.poetrist.gui.model.Flower;

/**
 * This class is a representation of the flower.
 * 
 * @author louis
 * 
 */
public class FlowerViewObject implements Observer
{
	private Flower flower;
	private double height;
	/**
	 * The stigma's representation.
	 */
	private StigmaViewObject stigma = null;

	/**
	 * The representation of the tepals.
	 */
	private List<TepalViewObject> tepals = null;
	private double width;

	private double xPosition;

	private double yPosition;

	/**
	 * Creates a representation of the flower.
	 * 
	 * @param flower
	 *            The flower.
	 * @param xPos
	 *            The x position of the centre of the flower.
	 * @param yPos
	 *            The y position of the centre of the flower.
	 * @param height
	 *            The height of the flower, measured from the lowest point to
	 *            the centre of the flower.
	 * @param width
	 *            The width of the flower's stem.
	 */
	public FlowerViewObject(Flower flower, double xPos, double yPos, double height, double width)
	{
		this.flower = flower;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;

		tepals = new ArrayList<TepalViewObject>();
		stigma = new StigmaViewObject(flower.getStigma(), xPos, yPos, 2 * width);

		flower.addObserver(this);
	}

	/**
	 * Creates a representation of the flower.
	 * 
	 * @param flower
	 *            The flower.
	 * @param stigmaViewObject
	 *            The representation of the stigma.
	 * @param xPos
	 *            The x position of the centre of the flower.
	 * @param yPos
	 *            The y position of the centre of the flower.
	 * @param height
	 *            The height of the flower, measured from the lowest point to
	 *            the centre of the flower.
	 * @param width
	 *            The width of the flower's stem.
	 */
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

	/**
	 * Add a tepal to the flower. If the flower already contains the tepal, or
	 * has no more free positions, the tepal is not added.
	 * 
	 * @param tepal
	 * @return <code>true</code> if the tepal is added to the flower,
	 *         <code>false</code> otherwise.
	 */
	public boolean addTepal(TepalViewObject tepal)
	{
		if (flower.addTepal(tepal.getTepal()))
		{
			tepals.add(tepal);
			return true;
		}

		return false;

	}

	/**
	 * Returns the flower.
	 * 
	 * @return the flower.
	 */
	public Flower getFlower()
	{
		return flower;
	}

	/**
	 * Paints the flower onto the canvas.
	 * 
	 * @param g
	 */
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		// move to separate inner-class?
		Rectangle2D stem = new Rectangle2D.Double(xPosition - 0.5 * width, yPosition, width, height);
		g2.setColor(Color.GREEN);
		g2.fill(stem);

		for (TepalViewObject tepal : tepals)
		{
			tepal.paint(g);
		}

		stigma.paint(g);

	}

	@Override
	public void update(Observable o, Object arg)
	{
		if (arg == flower)
		{
			System.out.println("NICE!");
		}

	}
}
