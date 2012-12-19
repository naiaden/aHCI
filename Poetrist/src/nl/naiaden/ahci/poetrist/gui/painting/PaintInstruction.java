/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.painting;

import java.awt.Graphics2D;

/**
 * @author louis
 *
 */
public interface PaintInstruction
{
	public Graphics2D perform(Graphics2D canvas);
}
