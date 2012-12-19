/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.PaintInstruction;

import processing.core.PApplet;

/**
 * @author louis
 *
 */
public class Painting extends JPanel
{
	private double width = 0;
	private double height = 0;

	private List<PaintInstruction> paintInstructions = null;

	public double getPaintingWidth()
	{
		return width;
	}

	public double getPaintingHeight()
	{
		return height;
	}

	public Painting(double width, double height)
	{
		paintInstructions = new ArrayList<PaintInstruction>();

	}

	public void show(Graphics g)
	{
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
