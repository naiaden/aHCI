/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.assocations.WeightedColor;
import nl.naiaden.ahci.poetrist.gui.painting.Painter;
import nl.naiaden.ahci.poetrist.gui.painting.Painting;

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

		System.out.println("Paintings: " + paintings.size());
		for (int l = 0; l < paintings.size(); ++l)
		{
			int w = l % galleryWidth;
			int h = l / galleryWidth;
			gbc.gridx = w;
			gbc.gridy = h;

			if (paintings.get(w + galleryWidth * h) != null)
			{
				System.out.println("Processing (" + w + "," + h + ")");


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
		Painter painter = new Painter(weightedColors);

		for (int i = 0; i < 3; ++i)
		{

			// JFrame frame = new JFrame("PainterDemo");
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//
			// JPanel panel = new JPanel();
			//
			// Painting painting = painter.paint(400, 300);
			//
			// frame.setSize(400, 300);
			// frame.setVisible(true);
			//
			// frame.getContentPane().add(painting);

			addPainting(painter.paint(400, 300));
		}

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
