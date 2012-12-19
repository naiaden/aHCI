/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Label;
import java.awt.Point;

import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;

/**
 * @author louis
 *
 */
public class FlowerPartToolTip
{
	private Label toolTipLabel = null;
	private Point position = null;
	private FlowerPartViewObject flowerPart = null;
	
	public FlowerPartToolTip(Point point, FlowerPartViewObject flowerPart)
	{

		position = point;
		this.flowerPart = flowerPart;

		toolTipLabel = new Label(flowerPart.getWord());
	}

	public String getLabel()
	{
		return flowerPart.getWord();
	}

	public Point getPosition()
	{
		return position;
	}

	public void hideToolTip()
	{

	}
}
