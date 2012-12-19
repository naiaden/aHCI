/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * @author louis
 *
 */
public class GalleryPanel extends JPanel
{

	private int numberOfPaintings = 3;

	public void setNumberOfPaintings(int numberOfPaintings)
	{
		this.numberOfPaintings = numberOfPaintings;
	}

	public int getNumberOfPaintings()
	{
		return numberOfPaintings;
	}

	// private List<Painting> paintings = null;
	//
	// public GalleryPanel()
	// {
	// paintings = new ArrayList<Painting>();
	// }

	/**
	 * 
	 */
	private static final long serialVersionUID = -5783192163210686165L;

	public void paint(Graphics graphics)
	{

	}

}
