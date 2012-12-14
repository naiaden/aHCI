package nl.naiaden.ahci.poetrist.gui;

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

import nl.naiaden.ahci.poetrist.gui.panel.ColorSelectionPanel;
import nl.naiaden.ahci.poetrist.gui.panel.FlowerPartPotPanel;
import nl.naiaden.ahci.poetrist.gui.panel.GardenPanel;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;

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

		new FlowerPartPotDropTargetListener(flowerPotPanel);
		DragSource gardenPanelDragSource = new DragSource();
		gardenPanelDragSource.createDefaultDragGestureRecognizer(gardenPanel, DnDConstants.ACTION_COPY, this);

		new GardenDropTargetListener(gardenPanel);
		DragSource colorSelectionPanelDragSource = new DragSource();
		colorSelectionPanelDragSource.createDefaultDragGestureRecognizer(colorSelectionPanel, DnDConstants.ACTION_COPY, this);
		// new DropTarget(flowerPotPanel, DnDConstants.ACTION_COPY, this);

		this.setSize(700, 700);
	}

	private void initialiseFrame()
	{
		setTitle("Poetrist -- Your source of click and point art generation");

		gardenPanel = new GardenPanel();
		colorSelectionPanel = new ColorSelectionPanel();
		flowerPotPanel = new FlowerPartPotPanel();

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
		System.out.println("[PoetristFrame#dragGestureRecognized]");

		FlowerPartViewObject selectedFlowerPart = gardenPanel.selectedFlowerPart(arg0.getDragOrigin());

		if (selectedFlowerPart != null)
		{

			Cursor cursor = null;
			JPanel source = (JPanel) arg0.getComponent();

			if (arg0.getDragAction() == DnDConstants.ACTION_COPY)
			{
				cursor = DragSource.DefaultCopyDrop;
			}

			arg0.startDrag(cursor, new TransferableFlowerPart(selectedFlowerPart));
		}

	}

}
