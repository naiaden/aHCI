/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.Observer;

/**
 * @author louis
 * 
 */
public interface FlowerPartViewObject extends Observer
{
	/**
	 * Paints the flower onto the canvas.
	 * 
	 * @param g
	 */
	public void paint(Graphics g);

	/**
	 * Returns the representation of the flower part.
	 * 
	 * @return the shape representation of the flower part.
	 */
	public Shape getShape();

	/**
	 * Tests whether a point is located within the shape.
	 * 
	 * @param xPos
	 *            The x position to be tested.
	 * @param yPos
	 *            The y position to be tested.
	 * @return <code>true</code> is the position (xPos, yPos) is within the
	 *         shape. <code>false</code> otherwise
	 */
	public boolean positionInShape(Point2D position);

	public boolean isSelected();

	public void setSelected(boolean selected);
}
