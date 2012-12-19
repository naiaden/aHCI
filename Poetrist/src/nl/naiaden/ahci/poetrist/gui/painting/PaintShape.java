/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.painting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;


/**
 * @author louis
 *
 */
public class PaintShape implements PaintInstruction
{
	private final Shape newShape;

	public PaintShape(Shape newShape)
	{
		this.newShape = newShape;
	}

	/* (non-Javadoc)
	 * @see nl.naiaden.ahci.poetrist.PaintInstruction#perform()
	 */
	@Override
	public Graphics2D perform(Graphics2D canvas)
	{
		canvas.fill(newShape);
		return canvas;
	}

}
