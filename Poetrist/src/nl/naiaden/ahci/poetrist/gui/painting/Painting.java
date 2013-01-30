/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.painting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.Application;

/**
 * Based on William's code.
 * 
 * @author louis
 * 
 */
public class Painting extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4395617656139402127L;
	private double width = 0;
	private double height = 0;
	private Color canvasColor;

	private final int number = Application.GetPaintingNumber();

	private List<PaintInstruction> paintInstructions = null;

	public void setCanvasColor(Color color)
	{
		canvasColor = color;
	}

	public int getNumber()
	{
		return number;
	}

	public double getPaintingWidth()
	{
		return width;
	}

	public double getPaintingHeight()
	{
		return height;
	}

	// public boolean containsPoint(Point p)
	// {
	// return contains(p);
	// }

	public Painting(double width, double height)
	{
		paintInstructions = new ArrayList<PaintInstruction>();

		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e)
			{

			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				Application.LOGWRITER.system("Clicked on PAINTING " + number);
			}
		});
	}

	public void show(Graphics g)
	{
		this.setBackground(canvasColor);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (PaintInstruction paintInstruction : paintInstructions)
		{
			g2 = paintInstruction.perform(g2);
		}
	}

	public void paintComponent(Graphics g)
	{
		show(g);
	}

	public boolean addPaintInstruction(PaintInstruction paintInstruction)
	{
		return paintInstructions.add(paintInstruction);
	}

}
