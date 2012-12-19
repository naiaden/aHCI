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

import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;

/**
 * @author William
 * @author louis
 * 
 */
public class Painter
{
	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("PainterDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		Painter painter = new Painter();
		Painting painting = painter.paint(400, 300);



		frame.setSize(400, 300);
		frame.setVisible(true);

		frame.getContentPane().add(painting);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}

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

	private float randomFromTo(double from, double to)
	{
		float random = new Random().nextFloat();
		double difference = Math.abs(to - from);

		random *= difference;
		random += Math.min(from, to);

		return random;
	}

	public Painting paint(double width, double height)
	{
		Painting painting = new Painting(width, height);

		Random r = new Random();

		int backgroundColor = Color.HSBtoRGB(backgroundHue(), randomFromTo(90, 100), randomFromTo(75, 100));
		painting.setCanvasColor(new Color(backgroundColor));
		
		for (int i = 0; i < 200; ++i)
		{
			int fillColor = Color.HSBtoRGB(shapeHue(), randomFromTo(90, 100), randomFromTo(75, 100));
			painting.addPaintInstruction(new ChangeColor(new Color(fillColor)));
			
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
