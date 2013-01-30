/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.Application;
import nl.naiaden.ahci.poetrist.assocations.WeightedColor;
import nl.naiaden.ahci.poetrist.gui.painting.AbstractPainter;
import nl.naiaden.ahci.poetrist.gui.painting.Painting;
import nl.naiaden.ahci.poetrist.gui.painting.RandomPainter;

/**
 * @author louis
 *
 */
public class GalleryPanel extends JPanel
{

	private int numberOfPaintings = 6;

	public void setNumberOfPaintings(int numberOfPaintings)
	{
		this.numberOfPaintings = numberOfPaintings;
	}

	public int getNumberOfPaintings()
	{
		return numberOfPaintings;
	}

	public boolean addPainting(Painting painting)
	{
		System.out.println("Adding painting");

		initialise();

		revalidate();
		repaint();

		return paintings.add(painting);
	}

	public boolean removePainting(Painting painting)
	{
		return paintings.remove(painting);
	}

	private List<Painting> paintings = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5783192163210686165L;


	private int galleryWidth = 3;
	private int galleryHeight = 2;

	public int gallerySize()
	{
		return paintings.size();
	}

	public Painting removePainting(int index)
	{
		return paintings.remove(index);
	}

	private void initialise()
	{
		setLayout(new GridBagLayout());
		JPanel bgPanel = new JPanel();

		GridBagConstraints bgGbc = new GridBagConstraints();
		bgGbc.weightx = 1;
		bgGbc.weighty = 1;
		bgGbc.fill = GridBagConstraints.BOTH;
		bgGbc.gridx = 0;
		bgGbc.gridy = 0;

		GridBagConstraints gbc = new GridBagConstraints();
		bgPanel.setLayout(new GridBagLayout());
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		// System.out.println("Paintings: " + paintings.size());
		for (int l = 0; l < paintings.size(); ++l)
		{
			int w = l % galleryWidth;
			int h = l / galleryWidth;
			gbc.gridx = w;
			gbc.gridy = h;

			if (paintings.get(w + galleryWidth * h) != null)
			{
				// System.out.println("Processing (" + w + "," + h + ")");


				bgPanel.add(paintings.get(w + galleryWidth * h), gbc);

				revalidate();
				repaint();
			}
		}

		add(bgPanel, bgGbc);


	}

	public GalleryPanel()
	{
		paintings = new ArrayList<Painting>(galleryHeight * galleryWidth);

		initialise();



	}

	public void createGallery(List<WeightedColor> weightedColors)
	{
		AbstractPainter abstractPainter = new AbstractPainter(weightedColors);
		RandomPainter rPainter = new RandomPainter();

		paintings = new ArrayList<Painting>(galleryHeight * galleryWidth);

		Random r = new Random();
		int randomPosition = r.nextInt(numberOfPaintings);

		for (int i = 0; i < numberOfPaintings; ++i)
		{
			if (i == randomPosition)
			{
				Painting p = abstractPainter.paint(400, 300);
				Application.LOGWRITER.system("Generated painting (" + p.getNumber() + ") on " + i + " of " + numberOfPaintings);
				addPainting(p);
			}
			else
			{
				addPainting(rPainter.paint(400, 300));
			}
		}

		// for(int p = 0; p < paintings.size(); ++p)
		// {
		// Application.LOGWRITER.writeImage()
		// }

		initialise();

	}

	// public static void main(String[] args)
	// {
	// javax.swing.SwingUtilities.invokeLater(new Runnable()
	// {
	// public void run()
	// {
	// createAndShowGUI();
	// }
	// });
	// }
	//
	// /**
	// * Create the GUI and show it.
	// */
	// private static void createAndShowGUI()
	// {
	// JFrame frame = new JFrame("FUCKTHISSHITDEMO");
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//
	// GalleryPanel gp = new GalleryPanel();
	//
	// frame.getContentPane().add(gp);
	//
	// frame.setSize(400, 300);
	// frame.setVisible(true);
	// }

}
