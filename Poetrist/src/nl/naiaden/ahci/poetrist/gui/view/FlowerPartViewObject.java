/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.Observer;

/**
 * The interface for objects that are part of a flower.
 * 
 * @author louis
 * 
 */
public interface FlowerPartViewObject extends Observer
{
	/**
	 * Returns the representation of the flower part.
	 * 
	 * @return the shape representation of the flower part.
	 */
	public Shape getShape();

	/**
	 * Returns the state of the object's representation.
	 * 
	 * @return <code>true</code> if the representation is selected,
	 *         <code>false</code> otherwise.
	 */
	public boolean isSelected();

	/**
	 * Paints the flower onto the canvas.
	 * 
	 * @param g
	 *            The canvas.
	 */
	public void paint(Graphics g);

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

	/**
	 * Set the state of the object's representation.
	 * 
	 * @param selected
	 *            <code>true</code> if the representation is selected,
	 *            <code>false</code> otherwise.
	 */
	public void setSelected(boolean selected);

	/**
	 * Set the state of the object's representation depending on the position.
	 * 
	 * @param position
	 *            The position to check for. Iff the representation contains the
	 *            position, the representation is selected.
	 * @return <code>true</code> if the representation is selected,
	 *         <code>false</code> otherwise.
	 */
	public boolean setSelectedIfInPosition(Point2D position);

	/**
	 * The string representation of a flower part.
	 * 
	 * @return a one-line string representation of the flower part.
	 */
	public String toString();
}
