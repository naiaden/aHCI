/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import nl.naiaden.ahci.poetrist.Application;
import nl.naiaden.ahci.poetrist.gui.model.Flower;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;

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

	private StemViewObject stem = null;

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
		this(flower, new StigmaViewObject(flower.getStigma(), xPos, yPos, 2 * width), xPos, yPos, height, width);
		
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
		int tepalPosition = 0;

		for(Tepal tepal : flower.getTepals())
		{
			double widthVariation = Application.RANDOMGEN.nextDouble() / 2.0 + 0.75;
			// double rotationVariation = r.nextDouble() / 6 + 0.83;
			tepals.add(new TepalViewObject(tepal, xPos, yPos, 100, widthVariation * flower.getNumberOfTepalPositions(), tepalPosition++ * (2 * Math.PI)
					/ flower.getNumberOfTepalPositions()));
		}
		
		stigma = stigmaViewObject;
		
		stem = new StemViewObject(xPos, yPos, height);
		
		flower.addObserver(this);
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

	public FlowerPartViewObject getSelectedFlowerPart(Point point)
	{
		FlowerPartViewObject selectedPart = null;

		if (stigma.positionInShape(point)) { return stigma; }
		for (TepalViewObject tepal : tepals)
		{
			if (tepal.positionInShape(point)) { return tepal; }
		}

		return selectedPart;
	}

	/**
	 * 
	 * @param e
	 */
	public void mousePressed(MouseEvent e)
	{
		Point2D position = new Point2D.Double(e.getX(), e.getY());

		if (stigma.setSelectedIfInPosition(position))
		{
			for (TepalViewObject tepal : tepals)
			{
				tepal.setSelected(false);
			}
		} else
		{
			for (TepalViewObject tepal : tepals)
			{
				tepal.setSelectedIfInPosition(position);
			}
		}

	}

	/**
	 * Paints the flower onto the canvas.
	 * 
	 * @param g
	 *            The canvas.
	 */
	public void paint(Graphics g)
	{
		stem.paint(g);

		for (TepalViewObject tepal : tepals)
		{
			tepal.paint(g);
		}

		stigma.paint(g);
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

	@Override
	public String toString()
	{
		return "Flower (" + getFlower().getStigma().getWordColor() + ") with " + getFlower().getTepals().size() + "/" + getFlower().getNumberOfTepalPositions() + " tepals";
	}
}

/**
 * The visual representation of the flower's stem. It is technically not a view
 * object, since there is no underlying model for the object. However, for
 * symmetry reasons, it is named this way.
 * 
 * @author louis
 * 
 */
class StemViewObject
{
	double xPosition;
	double yPosition;
	double height;

	double xSwingTop;
	double xSwingBottom;

	/**
	 * Creates a stem. A stem is not a straight line, but wear and tear in
	 * nature, and gravity of course, caused the stem to bend a bit.
	 * 
	 * @param xPos
	 *            The x position of the stem.
	 * @param yPos
	 *            The y position of the stem.
	 * @param height
	 *            The height of the stem.
	 */
	public StemViewObject(double xPos, double yPos, double height)
	{
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;

		xSwingTop = Application.RANDOMGEN.nextGaussian() * 15;
		xSwingBottom = Application.RANDOMGEN.nextGaussian() * 7;
	}

	/**
	 * Paints the stem onto the canvas.
	 * 
	 * @param g
	 *            The canvas.
	 */
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.GREEN);
		CubicCurve2D c = new CubicCurve2D.Double(xPosition, yPosition, xPosition + xSwingTop, yPosition + (height * 0.33), xPosition + xSwingBottom, yPosition + (height * 0.66),
				xPosition, yPosition + height);
		g2.draw(c);

	}
}
