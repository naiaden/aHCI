package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import nl.naiaden.ahci.poetrist.gui.model.Flower;
import nl.naiaden.ahci.poetrist.gui.model.Stigma;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;
import nl.naiaden.ahci.poetrist.gui.view.FlowerViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

public class GardenPanel extends JPanel implements MouseInputListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7043512667139679491L;

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
		JFrame frame = new JFrame("GardenPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GardenPanel gp = new GardenPanel();

		double xpos = 150;
		double ypos = 150;

		int nrPetals = 8;

		Stigma s1 = new Stigma(Color.YELLOW);
		Flower f1 = new Flower(s1, nrPetals);

		Stigma s2 = new Stigma(Color.WHITE);
		Flower f2 = new Flower(s2, 6);

		Stigma s3 = new Stigma(Color.CYAN);
		Flower f3 = new Flower(s3, 8);

		FlowerViewObject fvo1 = new FlowerViewObject(f1, xpos, ypos, 150, 7);
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 1 * (2 * Math.PI) / nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 2 * (2 * Math.PI) / nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 3 * (2 * Math.PI) / nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 4 * (2 * Math.PI) / nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 5 * (2 * Math.PI) / nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 6 * (2 * Math.PI) / nrPetals));
		fvo1.addTepal(new TepalViewObject(new Tepal(Color.RED), xpos, ypos, 100, nrPetals, 7 * (2 * Math.PI) / nrPetals));
		gp.addFlower(fvo1);

		xpos = xpos - 100;
		ypos = ypos + 50;
		nrPetals = 6;
		FlowerViewObject fvo2 = new FlowerViewObject(f2, xpos, ypos, 150, 7);
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 1 * (2 * Math.PI) / nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 2 * (2 * Math.PI) / nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 3 * (2 * Math.PI) / nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 4 * (2 * Math.PI) / nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 5 * (2 * Math.PI) / nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 6 * (2 * Math.PI) / nrPetals));
		fvo2.addTepal(new TepalViewObject(new Tepal(Color.BLUE), xpos, ypos, 100, nrPetals, 7 * (2 * Math.PI) / nrPetals));
		gp.addFlower(fvo2);

		xpos = xpos + 250;
		ypos = ypos - 50;
		nrPetals = 8;
		FlowerViewObject fvo3 = new FlowerViewObject(f3, xpos, ypos, 150, 7);
		fvo3.addTepal(new TepalViewObject(new Tepal(Color.YELLOW), xpos, ypos, 100, nrPetals));
		fvo3.addTepal(new TepalViewObject(new Tepal(Color.MAGENTA), xpos, ypos, 100, nrPetals, 1 * (2 * Math.PI) / nrPetals));
		fvo3.addTepal(new TepalViewObject(new Tepal(Color.YELLOW), xpos, ypos, 100, nrPetals, 2 * (2 * Math.PI) / nrPetals));
		fvo3.addTepal(new TepalViewObject(new Tepal(Color.MAGENTA), xpos, ypos, 100, nrPetals, 3 * (2 * Math.PI) / nrPetals));
		fvo3.addTepal(new TepalViewObject(new Tepal(Color.YELLOW), xpos, ypos, 100, nrPetals, 4 * (2 * Math.PI) / nrPetals));
		fvo3.addTepal(new TepalViewObject(new Tepal(Color.MAGENTA), xpos, ypos, 100, nrPetals, 5 * (2 * Math.PI) / nrPetals));
		// fvo3.addTepal(new TepalViewObject(new Tepal(Color.YELLOW), xpos,
		// ypos, 100, nrPetals,6*(2*Math.PI)/nrPetals));
		// fvo3.addTepal(new TepalViewObject(new Tepal(Color.YELLOW), xpos,
		// ypos, 100, nrPetals,7*(2*Math.PI)/nrPetals));
		gp.addFlower(fvo3);

		frame.getContentPane().add(gp);

		frame.setSize(400, 300);
		frame.setVisible(true);
	}

	/**
	 * 
	 */
	private List<FlowerViewObject> flowers = null;

	/**
	 * 
	 */
//	private JPanel gardenPanel = null;

	/**
	 * Default constructor.
	 */
	public GardenPanel()
	{
//		gardenPanel = new JPanel();

		flowers = new ArrayList<FlowerViewObject>();

		addMouseListener(this);
	}

	/**
	 * 
	 * @param flower
	 */
	public void addFlower(FlowerViewObject flower)
	{
		flowers.add(flower);
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

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		System.out.println("[GardenPanel] Mouse Pressed: (" + e.getX() + "," + e.getY() + ")");

		for (FlowerViewObject flower : flowers)
		{
			flower.mousePressed(e);
		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (FlowerViewObject flower : flowers)
		{
			flower.paint(g);
		}

	}

}
