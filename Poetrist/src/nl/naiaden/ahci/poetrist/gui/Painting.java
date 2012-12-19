/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.core.PApplet;

/**
 * @author louis
 *
 */
public class Painting extends JPanel
{
	private double width = 0;
	private double height = 0;

	private List<Shape> shapes = null;

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
		Graphics g = getGraphics();
		Graphics2D g2 = (Graphics2D) g;

		for (Shape shape : shapes)
		{
			g2.draw(shape);
		}
	}

	public boolean addShape(Shape shape)
	{
		return shapes.add(shape);
	}

}
