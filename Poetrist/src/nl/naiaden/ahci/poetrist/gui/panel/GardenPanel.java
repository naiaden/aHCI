package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import nl.naiaden.ahci.poetrist.gui.FlowerPartToolTip;
import nl.naiaden.ahci.poetrist.gui.model.Flower;
import nl.naiaden.ahci.poetrist.gui.model.Stigma;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;
import nl.naiaden.ahci.poetrist.gui.view.FlowerViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

public class GardenPanel extends JPanel implements MouseInputListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7043512667139679491L;

	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("GardenPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GardenPanel gp = new GardenPanel();

		frame.getContentPane().add(gp);

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
	 * The flowers in the garden.
	 */
	private List<FlowerViewObject> flowers = null;

	/**
	 * Default constructor.
	 */
	public GardenPanel()
	{
		flowers = new ArrayList<FlowerViewObject>();

		setPreferredSize(new Dimension(600, 600));

		revalidate();
		repaint();

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	/**
	 * Adds a flower to the garden.
	 * 
	 * @param flower
	 *            The new flower.
	 */
	public void addFlower(FlowerViewObject flower)
	{
		flowers.add(flower);

		revalidate();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	private long lastHover = 0;

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// lastHover = System.currentTimeMillis();
		FlowerPartViewObject hoverOnFlower = selectedFlowerPart(e.getPoint());
		if (hoverOnFlower != null)
		{
			toolTip = new FlowerPartToolTip(e.getPoint(), hoverOnFlower);
		} else
		{
			toolTip = null;
		}

		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// System.out.println("[GardenPanel] Mouse Pressed: (" + e.getX() + ","
		// + e.getY() + ")");

		for (FlowerViewObject flower : flowers)
		{
			flower.mousePressed(e);
		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// if(selectedObject != null)
		// {
		// selectedObject = null;
		// }
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		setOpaque(false);

		// the colour is skyblue
		GradientPaint gp = new GradientPaint(0, 0, new Color(135, 206, 235), 0, getHeight(), Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(gp);
		g2.fillRect(0, 0, getWidth(), getHeight());

		for (FlowerViewObject flower : flowers)
		{
			flower.paint(g);
		}

		if (toolTip != null)
		{
			toolTip.paint(g, this);
		}

		setOpaque(true);

	}

	private FlowerPartToolTip toolTip = null;

	/**
	 * Returns the flower part that is selected. Currently the oldest flower
	 * part has preference over the other parts. This is not by definition the
	 * (best) visible flower part.
	 * 
	 * @param point
	 *            The position to check for.
	 * @return the oldest flower part on the selected point. If no flower part
	 *         is available
	 */
	public FlowerPartViewObject selectedFlowerPart(Point point)
	{

		for (FlowerViewObject flower : flowers)
		{
			if (flower.getSelectedFlowerPart(point) != null)
				return flower.getSelectedFlowerPart(point);
		}

		return null;
	}

}
