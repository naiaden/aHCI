/**
 * 
 */
package nl.naiaden.ahci.poetrist;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.naiaden.ahci.poetrist.gui.Painting;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;

/**
 * @author William
 * @author louis
 * 
 */
public class Painter
{
	private List<ColorDistribution> colorDistributions = null;

	public Painter()
	{
		colorDistributions = new ArrayList<ColorDistribution>();
		initialiseDistributions();
	}

	public List<ColorDistribution> getColorDistributions()
	{
		return colorDistributions;
	}

	public boolean setColorDistribution(Color color, double percentage)
	{

		for (ColorDistribution cd : colorDistributions)
		{
			if (cd.getColor().equals(color))
			{
				cd.setPercentage(percentage);

				return true;
			}
		}

		return false;
	}

	private void initialiseDistributions()
	{
		List<ColorName> colors = AssociationFactory.getColors();
		double numberOfColors = colors.size();

		for (ColorName colorName : colors)
		{
			colorDistributions.add(new ColorDistribution(colorName.getColor(), 1.0 / numberOfColors));
		}
	}

	private double randomFromTo(double from, double to)
	{
		double random = new Random().nextDouble();
		double difference = Math.abs(to - from);

		random *= difference;
		random -= Math.min(from, to);

		return random;
	}

	public Painting paint(Graphics graphics, double width, double height)
	{
		Painting painting = new Painting(width, height);

		Random r = new Random();

		for (int i = 0; i < 200; ++i)
		{
			if (r.nextDouble() < 0.5)
			{

				double x = randomFromTo(width / 8, ((width / 8) * 7));
				double y = randomFromTo(height / 8, ((height / 8) * 7));
				double w = randomFromTo(width / 6, width / 3);
				double h = randomFromTo(height / 6, height / 3);
				Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
			} else
			{
				Polygon quadrilateral = new Polygon();
				for (int j = 0; j < 4; ++j)
				{
					quadrilateral.addPoint(r.nextInt((int) width), r.nextInt((int) height));
				}
			}
		}

		return painting;
	}

	private double backgroundHue(List<Double> colors, List<Double> perc)
	{
		double hue = 0;

		int numberOfColors = AssociationFactory.getColors().size();

		if (colors.size() == perc.size() && colors.size() == numberOfColors)
		{
			for (int i = 0; i < numberOfColors; ++i)
			{
				hue += (colors.get(i) * perc.get(i));
			}
		}

		return hue;
	}

	private double shapeHue(List<Double> colors, List<Double> perc)
	{
		Random r = new Random();
		double randomValue = r.nextDouble();
		
		if (colors.size() == perc.size())
		{
			for (int i = 0; i < colors.size(); ++i)
			{
				if (randomValue < perc.get(i)) { return colors.get(i); }
			}
		}
		
		return 0;
	}
}
