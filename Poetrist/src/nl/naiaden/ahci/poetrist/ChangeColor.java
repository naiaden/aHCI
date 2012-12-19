/**
 * 
 */
package nl.naiaden.ahci.poetrist;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author louis
 *
 */
public class ChangeColor implements PaintInstruction
{
	private final Color newColor;

	public ChangeColor(Color newColor)
	{
		this.newColor = newColor;
	}

	/* (non-Javadoc)
	 * @see nl.naiaden.ahci.poetrist.PaintInstruction#perform()
	 */
	@Override
	public Graphics2D perform(Graphics2D canvas)
	{
		canvas.setColor(newColor);
		return canvas;
	}

}
