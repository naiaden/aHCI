package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;

public class FlowerPartPotPanel extends JPanel implements MouseInputListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 631892447445446136L;

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

	private List<FlowerPartViewObject> flowerParts;

	public void addFlowerPart(FlowerPartViewObject flowerPart)
	{
		flowerParts.add(flowerPart);

		revalidate();
		repaint();
	}

	/**
	 * Default constructor.
	 */
	public FlowerPartPotPanel()
	{
		flowerParts = new ArrayList<FlowerPartViewObject>();

		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

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
