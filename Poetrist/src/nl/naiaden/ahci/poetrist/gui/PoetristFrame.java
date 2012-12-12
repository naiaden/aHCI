package nl.naiaden.ahci.poetrist.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.gui.model.Flower;
import nl.naiaden.ahci.poetrist.gui.model.Stigma;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;
import nl.naiaden.ahci.poetrist.gui.panel.ColorSelectionPanel;
import nl.naiaden.ahci.poetrist.gui.panel.FlowerPartPotPanel;
import nl.naiaden.ahci.poetrist.gui.panel.GardenPanel;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;
import nl.naiaden.ahci.poetrist.gui.view.FlowerViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

/**
 * This is the frame that connects all the individual components into the main
 * application.
 * 
 * @author louis
 * 
 */
public class PoetristFrame extends JFrame implements DragGestureListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3465836273841215128L;

	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI()
	{
		PoetristFrame frame = new PoetristFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	private Panel rootPanel = null;

	public PoetristFrame()
	{
		rootPanel = new Panel(new GridLayout(2, 2));

		initialiseFrame();
		add(rootPanel);

		new FlowerPartDropTargetListener(flowerPotPanel);
		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(gardenPanel, DnDConstants.ACTION_COPY, this);

		this.setSize(700, 700);
	}

	private void initialiseFrame()
	{
		setTitle("Poetrist -- Your source of click and point art generation");

		gardenPanel = new GardenPanel();
		colorSelectionPanel = new ColorSelectionPanel();
		flowerPotPanel = new FlowerPartPotPanel();

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

		gardenPanel.addFlower(fvo1);
		gardenPanel.addFlower(fvo2);
		gardenPanel.addFlower(fvo3);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		rootPanel.add(gardenPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		rootPanel.add(colorSelectionPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		rootPanel.add(flowerPotPanel, gbc);

	}

	private GardenPanel gardenPanel = null;
	private ColorSelectionPanel colorSelectionPanel = null;
	private FlowerPartPotPanel flowerPotPanel = null;

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0)
	{
		FlowerPartViewObject selectedFlowerPart = gardenPanel.selectedFlowerPart(arg0.getDragOrigin());


		if(selectedFlowerPart != null)
		{
			// if (selectedFlowerPart instanceof TepalViewObject)
			// {
			// TepalViewObject tepal = (TepalViewObject) selectedFlowerPart;
			//
			// Cursor cursor = null;
			// JPanel source = (JPanel) arg0.getComponent();
			//
			// if (arg0.getDragAction() == DnDConstants.ACTION_COPY)
			// {
			// cursor = DragSource.DefaultCopyDrop;
			// }
			//
			// arg0.startDrag(cursor, new TransferableFlowerPart(tepal));
			// }

			// if (selectedFlowerPart instanceof TepalViewObject)
			// {
			// TepalViewObject tepal = (TepalViewObject) selectedFlowerPart;

				Cursor cursor = null;
			// JPanel source = (JPanel) arg0.getComponent();

				if (arg0.getDragAction() == DnDConstants.ACTION_COPY)
				{
					cursor = DragSource.DefaultCopyDrop;
				}

			arg0.startDrag(cursor, new TransferableFlowerPart(selectedFlowerPart));
			// }
		}

		

	}

}
