package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.GridLayout;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.util.EventObject;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import nl.naiaden.ahci.poetrist.gui.SeedCellListRenderer;
import nl.naiaden.ahci.poetrist.gui.dnd.TransferableSeed;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedEvent;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedListener;
import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.WordColor;

/**
 * The seed list panel shows the content of a color, i.e. all the words that are
 * associated with that color are listed. These seeds can be dragged into
 * {@link GardenPanel}.
 * 
 * @author louis
 * @author Ding
 * 
 */
class SeedListPanel extends JPanel implements ColorChangedListener, DragSourceListener, DragGestureListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5625015010041351475L;
	private JScrollPane scrollPane = null;
	private JList seedList = null;
	private DefaultListModel seedListModel = new DefaultListModel();
	private GridLayout layout = null;

	/**
	 * Create a panel with seeds from a color.
	 */
	public SeedListPanel()
	{
		seedList = new JList();
		layout = new GridLayout(0, 1);
		setLayout(layout);

		seedList.setDragEnabled(true);
		seedList.setTransferHandler(new TransferHandler()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public int getSourceActions(JComponent c)
			{
				return COPY;
			}

			protected Transferable createTransferable(JComponent c)
			{
				JList list = (JList) c;
				Object value = list.getSelectedValue();
				if (value instanceof SeedViewObject)
				{
					SeedViewObject seed = (SeedViewObject) value;
					return new TransferableSeed(seed);
				}

				return null;
			}
		});

		seedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		seedList.setCellRenderer(new SeedCellListRenderer());

		scrollPane = new JScrollPane(seedList);
		add(scrollPane);

		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(seedList, DnDConstants.ACTION_COPY, this);

		initialise();

	}

	/**
	 * Initialise the seed list panel.
	 */
	public void initialise()
	{
		seedList.setModel(seedListModel);
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragDropEnd(DragSourceDropEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragEnter(DragSourceDragEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DragSourceEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DragSourceDragEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void handleColorChangedEvent(EventObject e)
	{
		if (e instanceof ColorChangedEvent)
		{
			ColorChangedEvent cce = (ColorChangedEvent) e;

			seedListModel.clear();
			
			for(WordColor wc : AssociationFactory.getWordColors())
			{
				if(wc.getColor().getColor().equals(cce.getColor()))
				{
					seedListModel.addElement(new SeedViewObject(wc));
				}
			}

			seedList.setModel(seedListModel);
		}

	}
}