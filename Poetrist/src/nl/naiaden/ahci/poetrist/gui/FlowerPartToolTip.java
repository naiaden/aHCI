/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.plaf.basic.BasicToolTipUI;

import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;
import nl.naiaden.ahci.poetrist.gui.view.StigmaViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

/**
 * @author louis
 *
 */
public class FlowerPartToolTip extends JToolTip
{
	public void paint(Graphics g, JComponent c)
	{
		Rectangle r = new Rectangle(toolTipLabel.getWidth(), toolTipLabel.getHeight());
		
//		Graphics2D g2 = (Graphics2D) g;
//		g2.fill(r);
//		g.draw
		
		// get metrics from the graphics
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		// get the height of a line of text in this
		// font and render context
		int hgt = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int adv = metrics.stringWidth(getLabel());
		// calculate the size of a box to hold the
		// text with some padding.
		Dimension size = new Dimension(adv+2, hgt+2);
		
		g.setColor(Color.white);
		g.fillRect((int) getPosition().getX(), (int) (getPosition().getY()-size.getHeight()), (int) size.getWidth() + 4, (int) (size.getHeight()));

		g.setColor(Color.black);
		g.drawString(getLabel(), 4 + (int) getPosition().getX(), (int) getPosition().getY() - 4);
		
		
	}
	
	private Label toolTipLabel = null;
	private Point position = null;
	private FlowerPartViewObject flowerPart = null;
	
	public FlowerPartToolTip(Point point, FlowerPartViewObject flowerPart)
	{

		position = point;
		this.flowerPart = flowerPart;

		toolTipLabel = new Label(flowerPart.getWord());
		setTipText(flowerPart.getWord());
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
