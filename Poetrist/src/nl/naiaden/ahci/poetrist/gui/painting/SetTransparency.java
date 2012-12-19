/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.painting;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

/**
 * @author louis
 *
 */
public class SetTransparency implements PaintInstruction
{

	private final float transparency;

	public SetTransparency(float transparency)
	{
		this.transparency = transparency;
	}

	/* (non-Javadoc)
	 * @see nl.naiaden.ahci.poetrist.gui.painting.PaintInstruction#perform(java.awt.Graphics2D)
	 */
	@Override
	public Graphics2D perform(Graphics2D canvas)
	{

		canvas.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));

		return canvas;
	}

}
