/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import nl.naiaden.ahci.poetrist.PaintInstruction;

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
		canvas.draw(newShape);
		return canvas;
	}

}
