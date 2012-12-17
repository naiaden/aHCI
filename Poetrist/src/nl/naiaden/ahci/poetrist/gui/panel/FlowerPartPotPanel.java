package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;

/**
 * This class represents your metaphorical basket. The tepals you ripped of the
 * flowers can be saved and brought to the next stage of the process in this
 * basket.
 * 
 * @author louis
 * 
 */
public class FlowerPartPotPanel extends JPanel implements MouseInputListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 631892447445446136L;

	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("FlowerPartPotPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FlowerPartPotPanel fpp = new FlowerPartPotPanel();

		frame.getContentPane().add(fpp);

		frame.setSize(400, 300);
		frame.setVisible(true);
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

	/**
	 * The flower parts in the basket.
	 */
	private List<FlowerPartViewObject> flowerParts;

	private FlowerPartViewObject selectedObject = null;

	/**
	 * Default constructor.
	 */
	public FlowerPartPotPanel()
	{
		flowerParts = new ArrayList<FlowerPartViewObject>();

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	/**
	 * Add a flower part to your basket.
	 * 
	 * @param flowerPart
	 *            The flower part.
	 */
	public void addFlowerPart(FlowerPartViewObject flowerPart)
	{
		flowerParts.add(flowerPart);

		revalidate();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{

		if (selectedObject != null)
		{
			selectedObject.setLocation(arg0.getPoint());
			revalidate();
			repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// if()

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		for (FlowerPartViewObject flowerPart : flowerParts)
		{
			if (flowerPart.positionInShape(arg0.getPoint()))
			{
				selectedObject = flowerPart;
				return;
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		if (selectedObject != null)
		{
			selectedObject = null;
		}

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (FlowerPartViewObject flowerPart : flowerParts)
		{
			flowerPart.paint(g);
		}

	}

}
