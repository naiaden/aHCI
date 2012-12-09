/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;

/**
 * This class is a representation of the tepal.
 * 
 * @author louis
 * 
 */
public class TepalViewObject implements FlowerPartViewObject
{

	private double height;

	private boolean isSelected = false;
	private double rotation;
	private Tepal tepal;

	private double width;
	private double xPosition;

	private double yPosition;

	/**
	 * Creates a representation of the tepal.
	 * 
	 * @param tepal
	 *            The tepal.
	 * @param xPos
	 *            The x position of which the tepal should shoot. (This is
	 *            typically the centre of the stigma)
	 * @param yPos
	 *            The y position of which the tepal should shoot. (This is
	 *            typically the centre of the stigma)
	 * @param height
	 *            The height of the tepal. (Currently not used)
	 * @param width
	 *            The reciprocal width of the tepal. (This is typically the
	 *            number of tepals on the flower).
	 */
	public TepalViewObject(Tepal tepal, double xPos, double yPos, double height, double width)
	{
		this(tepal, xPos, yPos, height, width, 0);
	}

	/**
	 * Creates a representation of the tepal.
	 * 
	 * @param tepal
	 *            The tepal.
	 * @param xPos
	 *            The x position of which the tepal should shoot. (This is
	 *            typically the centre of the stigma)
	 * @param yPos
	 *            The y position of which the tepal should shoot. (This is
	 *            typically the centre of the stigma)
	 * @param height
	 *            The height of the tepal. (Currently not used)
	 * @param width
	 *            The reciprocal width of the tepal. (This is typically the
	 *            number of tepals on the flower).
	 * @param rotation
	 *            The rotation in radians. The tepal rotates around (xPos,
	 *            yPos).
	 */
	public TepalViewObject(Tepal tepal, double xPos, double yPos, double height, double width, double rotation)
	{
		this.tepal = tepal;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.height = height;
		this.width = width;
		this.rotation = rotation;
	}

	@Override
	public Shape getShape()
	{
		return createTepal(100, (1.0 / (width / 2.0)) + 0.5);
	}

	/**
	 * Returns the tepal.
	 * 
	 * @return the tepal.
	 */
	public Tepal getTepal()
	{
		return tepal;
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

		g2.setColor(tepal.getColour());
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
		if (arg1.equals(tepal))
		{
			// it's for me!
		}

	}

	/**
	 * 
	 * @param p0
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	private Shape createCubicCurve(Point2D p0, Point2D p1, Point2D p2, Point2D p3)
	{
		// Added checking for big integers (>1000000)
		// when antialiasing is on it causes an exception:
		// sun.dc.pr.PRException: endPath: bad path
		// (java bug http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4696289)
		if (p0.getY() >= 1000000 || p1.getY() >= 1000000 || p2.getY() >= 1000000 || p3.getY() >= 1000000) {

		return null; }
		//

		return new CubicCurve2D.Double((int) p0.getX(), (int) p0.getY(), (int) p2.getX(), (int) p2.getY(), (int) p3.getX(), (int) p3.getY(), (int) p1.getX(), (int) p1.getY());
	}

	/**
	 * Creates the shape of the tepal
	 * 
	 * @param width
	 *            The width of the tepal.
	 * @param percent
	 *            The scaling of the tepal.
	 * @return a closed shape that resembles a tepal.
	 */
	private Shape createTepal(double width, double percent)
	{
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

		AffineTransform t = new AffineTransform();
		t.translate(xPosition, yPosition);
		t.rotate(rotation);
		t.translate(-xPosition, -yPosition);

		Shape transformedShape;
		transformedShape = t.createTransformedShape(shape);

		return transformedShape;
	}

}
