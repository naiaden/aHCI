/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.painting;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.assocations.WeightedColor;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;

/**
 * @author louis
 * 
 */
public class RandomPainter
{

	public RandomPainter(List<WeightedColor> colorDistribution)
	{

	}

	public Painting paint(double width, double height)
	{
		Painting painting = new Painting(width, height);

		Random r = new Random();

		int backgroundColor = Color.HSBtoRGB(backgroundHue(), randomFromTo(90, 100), randomFromTo(75, 100));
		painting.setCanvasColor(new Color(backgroundColor));

		for (int i = 0; i < 10; ++i)
		{
			// int fillColor = Color.HSBtoRGB(shapeHue(), randomFromTo(90, 100),
			// randomFromTo(75, 100));
			// int fillColor = r.nextInt(255);
			painting.addPaintInstruction(new ChangeColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))));

			float alpha = randomFromTo(90, 100) / 100;
			painting.addPaintInstruction(new SetTransparency(alpha));

			if (r.nextDouble() < 0.5)
			{

				double x = randomFromTo(width / 8, ((width / 8) * 7));
				double y = randomFromTo(height / 8, ((height / 8) * 7));
				double w = randomFromTo(width / 6, width / 3);
				double h = randomFromTo(height / 6, height / 3);
				Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
				painting.addPaintInstruction(new PaintShape(ellipse));
			} else
			{
				Polygon quadrilateral = new Polygon();
				for (int j = 0; j < 4; ++j)
				{
					quadrilateral.addPoint(r.nextInt((int) width), r.nextInt((int) height));
				}
				painting.addPaintInstruction(new PaintShape(quadrilateral));
			}
		}

		return painting;
	}




	private float randomFromTo(double from, double to)
	{
		float random = new Random().nextFloat();
		double difference = Math.abs(to - from);

		random *= difference;
		random += Math.min(from, to);

		return random;
	}

	// public Painting paint(double width, double height)
	// {
	// Painting painting = new Painting(width, height);
	//
	// Random r = new Random();
	//
	// int backgroundColor = Color.HSBtoRGB(backgroundHue(), randomFromTo(90,
	// 100), randomFromTo(75, 100));
	// painting.setCanvasColor(new Color(backgroundColor));
	//
	// for (int i = 0; i < 200; ++i)
	// {
	// int fillColor = Color.HSBtoRGB(shapeHue(), randomFromTo(90, 100),
	// randomFromTo(75, 100));
	// painting.addPaintInstruction(new ChangeColor(new Color(fillColor)));
	//
	// float alpha = randomFromTo(90, 100) / 100;
	// painting.addPaintInstruction(new SetTransparency(alpha));
	//
	// if (r.nextDouble() < 0.5)
	// {
	//
	// double x = randomFromTo(width / 8, ((width / 8) * 7));
	// double y = randomFromTo(height / 8, ((height / 8) * 7));
	// double w = randomFromTo(width / 6, width / 3);
	// double h = randomFromTo(height / 6, height / 3);
	// Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
	// painting.addPaintInstruction(new PaintShape(ellipse));
	// } else
	// {
	// Polygon quadrilateral = new Polygon();
	// for (int j = 0; j < 4; ++j)
	// {
	// quadrilateral.addPoint(r.nextInt((int) width), r.nextInt((int) height));
	// }
	// painting.addPaintInstruction(new PaintShape(quadrilateral));
	// }
	// }
	//
	// return painting;
	// }

	private float backgroundHue()
	{
		float hue = 0;

		if (col.length == perc.length)
		{
			for (int i = 0; i < col.length; ++i)
			{
				hue += (perc[i] * col[i]);
			}
		}

		return hue;
	}

	private float[] col =
	{ 0, 45, 90, 135, 180, 225, 270, 315 };
	private float[] perc =
	{ 0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f };

	private float shapeHue()
	{
		Random r = new Random();
		double randomValue = r.nextDouble();

		if (col.length == perc.length)
		{
			for (int i = 0; i < col.length; ++i)
			{
				if (randomValue < perc[i]) { return col[i]; }
			}
		}

		return 0f;
	}
}
