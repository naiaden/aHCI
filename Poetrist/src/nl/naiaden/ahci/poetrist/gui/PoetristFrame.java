package nl.naiaden.ahci.poetrist.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import nl.naiaden.ahci.poetrist.gui.dnd.BasketDropTargetListener;
import nl.naiaden.ahci.poetrist.gui.dnd.GardenDropTargetListener;
import nl.naiaden.ahci.poetrist.gui.dnd.TransferableFlowerPart;
import nl.naiaden.ahci.poetrist.gui.event.BasketChangedEvent;
import nl.naiaden.ahci.poetrist.gui.event.BasketChangedListener;
import nl.naiaden.ahci.poetrist.gui.panel.GalleryPanel;
import nl.naiaden.ahci.poetrist.gui.panel.SeedSelectionPanel;
import nl.naiaden.ahci.poetrist.gui.panel.BasketPanel;
import nl.naiaden.ahci.poetrist.gui.panel.GardenPanel;
import nl.naiaden.ahci.poetrist.gui.panel.PoemPanel;
import nl.naiaden.ahci.poetrist.gui.panel.WordSearchPanel;
import nl.naiaden.ahci.poetrist.gui.panel.WordSearchPanel;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;

/**
 * This is the frame that connects all the individual components into the main
 * application.
 * 
 * @author louis
 * 
 */
public class PoetristFrame extends JFrame implements DragGestureListener, BasketChangedListener
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

	public PoetristFrame()
	{
		initialiseFrame();

		new BasketDropTargetListener(basketPickingPanel);
		DragSource gardenPanelDragSource = new DragSource();
		gardenPanelDragSource.createDefaultDragGestureRecognizer(gardenPanel, DnDConstants.ACTION_MOVE, this);

		new GardenDropTargetListener(gardenPanel);
		DragSource colorSelectionPanelDragSource = new DragSource();
		colorSelectionPanelDragSource.createDefaultDragGestureRecognizer(seedSelectionPanel, DnDConstants.ACTION_COPY, this);

		this.setSize(700, 700);
	}

	private JPanel rootPanel = null;

	private GardenPanel gardenPanel = null;
	private SeedSelectionPanel seedSelectionPanel = null;
	private BasketPanel basketPickingPanel = null;

	private PoemPanel poemPanel = null;
	private WordSearchPanel wordSearchPanel= null;
	private BasketPanel basketBrewingPanel = null;

	private GalleryPanel galleryPanel = null;

	private JTabbedPane stepsInProcesTabPane = null;
	private JPanel pickingPanel = null;
	private JPanel brewingPanel = null;
	private JPanel tastingPanel = null;

	private void initialiseFrame()
	{
		setTitle("Poetrist -- Your source of click and point art generation");

		rootPanel = new JPanel(new GridLayout(2, 2));
		stepsInProcesTabPane = new JTabbedPane();

		gardenPanel = new GardenPanel();
		seedSelectionPanel = new SeedSelectionPanel();
		basketPickingPanel = new BasketPanel();
		basketPickingPanel.addEventListener(this);

		poemPanel = new PoemPanel();
		wordSearchPanel = new WordSearchPanel();
		wordSearchPanel.setGardenPanel(gardenPanel);
		basketBrewingPanel = new BasketPanel();
		basketBrewingPanel.addEventListener(this);

		galleryPanel = new GalleryPanel();
		poemPanel.setGalleryPanel(galleryPanel);

		// Picking panel

		pickingPanel = new JPanel(new GridBagLayout());
		GridBagConstraints pickingPanelGBC = new GridBagConstraints();
		pickingPanelGBC.fill = GridBagConstraints.BOTH;
		pickingPanelGBC.weightx = 1.0;
		pickingPanelGBC.weighty = 1.0;

		pickingPanelGBC.gridx = 0;
		pickingPanelGBC.gridy = 0;
		pickingPanel.add(gardenPanel, pickingPanelGBC);

		pickingPanelGBC.gridx = 1;
		pickingPanelGBC.gridy = 0;
		pickingPanel.add(seedSelectionPanel, pickingPanelGBC);

		pickingPanelGBC.gridx = 0;
		pickingPanelGBC.gridy = 1;
		pickingPanel.add(basketPickingPanel, pickingPanelGBC);

		stepsInProcesTabPane.add("Picking", pickingPanel);

		// Brewing panel

		brewingPanel = new JPanel(new GridBagLayout());
		GridBagConstraints brewingPanelGBC = new GridBagConstraints();
		brewingPanelGBC.fill = GridBagConstraints.BOTH;
		brewingPanelGBC.weightx = 1.0;
		brewingPanelGBC.weighty = 1.0;

		brewingPanelGBC.gridx = 0;
		brewingPanelGBC.gridy = 0;
		brewingPanel.add(poemPanel, brewingPanelGBC);
		
		brewingPanelGBC.gridx = 1;
		brewingPanelGBC.gridy = 0;
		brewingPanel.add(wordSearchPanel, brewingPanelGBC);

		brewingPanelGBC.gridx = 0;
		brewingPanelGBC.gridy = 1;
		brewingPanel.add(basketBrewingPanel, brewingPanelGBC);

		stepsInProcesTabPane.add("Brewing", brewingPanel);

		// Tasting panel

		tastingPanel = new JPanel(new GridBagLayout());
		GridBagConstraints tastingPanelGBC = new GridBagConstraints();
		tastingPanelGBC.fill = GridBagConstraints.BOTH;
		tastingPanelGBC.weightx = 1.0;
		tastingPanelGBC.weighty = 1.0;

		tastingPanelGBC.gridx = 0;
		tastingPanelGBC.gridy = 0;
		tastingPanel.add(galleryPanel, tastingPanelGBC);

		stepsInProcesTabPane.add("Tasting", tastingPanel);
		// stepsInProcesTabPane.add("TASDJAKSD", galleryPanel);

		//

		add(stepsInProcesTabPane);


	}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0)
	{
		System.out.println("[PoetristFrame#dragGestureRecognized]");

		FlowerPartViewObject selectedFlowerPart = gardenPanel.selectedFlowerPart(arg0.getDragOrigin());

		if (selectedFlowerPart != null)
		{

			Cursor cursor = null;
			JPanel source = (JPanel) arg0.getComponent();

			// if (arg0.getDragAction() == DnDConstants.ACTION_MOVE)
			// {
				cursor = DragSource.DefaultMoveDrop;
			// }

			arg0.startDrag(cursor, new TransferableFlowerPart(selectedFlowerPart));
		}

	}


	@Override
	public void handleBasketChangedEvent(BasketChangedEvent e)
	{
		basketPickingPanel.changeState(e);
		basketBrewingPanel.changeState(e);
	}

}
