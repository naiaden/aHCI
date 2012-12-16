package nl.naiaden.ahci.poetrist.gui;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import nl.naiaden.ahci.poetrist.gui.dnd.FlowerPartPotDropTargetListener;
import nl.naiaden.ahci.poetrist.gui.dnd.GardenDropTargetListener;
import nl.naiaden.ahci.poetrist.gui.dnd.TransferableFlowerPart;
import nl.naiaden.ahci.poetrist.gui.panel.SeedSelectionPanel;
import nl.naiaden.ahci.poetrist.gui.panel.FlowerPartPotPanel;
import nl.naiaden.ahci.poetrist.gui.panel.GardenPanel;
import nl.naiaden.ahci.poetrist.gui.panel.PeotryMakePanel;
import nl.naiaden.ahci.poetrist.gui.panel.PicturePanel;
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

	private JPanel rootPanel = null;
	private JPanel pedalPanel = null;
	private JPanel flowerColorPanel = null;
	private JPanel poetryPanel = null;
	private JPanel picPanel = null;


	JTabbedPane tabbedPane = new JTabbedPane();
	JTabbedPane tabbedPane2 = new JTabbedPane();
	

	public PoetristFrame()
	{
		rootPanel = new JPanel(new GridLayout(2, 1));
		pedalPanel = new JPanel(new GridLayout(1, 1));
		flowerColorPanel = new JPanel(new GridLayout(1,2));
		poetryPanel = new JPanel(new GridLayout(1, 1));
		picPanel = new JPanel();
		
		initialiseFrame();
		
		add(rootPanel);
	
		pedalPanel.add(flowerPotPanel);
		tabbedPane.addTab("garden",flowerColorPanel);
		tabbedPane.addTab("peotry", poetryPanel);
		rootPanel.add(tabbedPane);
		rootPanel.add(pedalPanel);
		
		tabbedPane2.addTab("poetry", rootPanel);
		tabbedPane2.addTab("picture",picPanel);
		add(tabbedPane2);
		
	
		new FlowerPartPotDropTargetListener(flowerPotPanel);
		DragSource gardenPanelDragSource = new DragSource();
		gardenPanelDragSource.createDefaultDragGestureRecognizer(gardenPanel, DnDConstants.ACTION_COPY, this);

		new GardenDropTargetListener(gardenPanel);
		DragSource colorSelectionPanelDragSource = new DragSource();
		colorSelectionPanelDragSource.createDefaultDragGestureRecognizer(seedSelectionPanel, DnDConstants.ACTION_COPY, this);
		// new DropTarget(flowerPotPanel, DnDConstants.ACTION_COPY, this);

		this.setSize(700, 700);
	}

	private void initialiseFrame()
	{
		setTitle("Poetrist -- Your source of click and point art generation");

		gardenPanel = new GardenPanel();
		seedSelectionPanel = new SeedSelectionPanel();
		flowerPotPanel = new FlowerPartPotPanel();
		PeotryMakePanel peotryMakePanel = new PeotryMakePanel();
		PicturePanel picturePanel = new PicturePanel();

	/*	GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		rootPanel.add(gardenPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		rootPanel.add(seedSelectionPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		rootPanel.add(flowerPotPanel, gbc);
*/		
		
		flowerColorPanel.add(gardenPanel);
		flowerColorPanel.add(seedSelectionPanel);
		poetryPanel.add(peotryMakePanel);
		pedalPanel.add(flowerPotPanel);
		picPanel.add(picturePanel);
		
	}

	private GardenPanel gardenPanel = null;
	private SeedSelectionPanel seedSelectionPanel = null;
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
