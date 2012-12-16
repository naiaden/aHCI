package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
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
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import nl.naiaden.ahci.poetrist.gui.SeedCellListRenderer;
import nl.naiaden.ahci.poetrist.gui.dnd.TransferableSeed;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedEvent;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedListener;
import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.Word;

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
	private JList seedList = null;
	private DefaultListModel seedListModel = new DefaultListModel();
	private GridLayout layout = null;

	private Map<Color, List<SeedViewObject>> colorWordMap = new HashMap<Color, List<SeedViewObject>>();

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

		add(seedList);

		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(seedList, DnDConstants.ACTION_COPY, this);

		// just temporarily
		// in a later stage these will be requested from the WordColorFactory

		List<SeedViewObject> green = new ArrayList<SeedViewObject>();
		green.add(new SeedViewObject(new Word("garden", Color.GREEN)));
		colorWordMap.put(Color.GREEN, green);

		List<SeedViewObject> blue = new ArrayList<SeedViewObject>();
		blue.add(new SeedViewObject(new Word("ditty", Color.BLUE)));
		colorWordMap.put(Color.BLUE, blue);

		List<SeedViewObject> orange = new ArrayList<SeedViewObject>();
		orange.add(new SeedViewObject(new Word("due", Color.ORANGE)));
		colorWordMap.put(Color.ORANGE, orange);

		List<SeedViewObject> white = new ArrayList<SeedViewObject>();
		white.add(new SeedViewObject(new Word("anterior", Color.WHITE)));
		white.add(new SeedViewObject(new Word("herewith", Color.WHITE)));
		white.add(new SeedViewObject(new Word("transcendental", Color.WHITE)));
		white.add(new SeedViewObject(new Word("tableware", Color.WHITE)));
		colorWordMap.put(Color.WHITE, white);

		List<SeedViewObject> black = new ArrayList<SeedViewObject>();
		black.add(new SeedViewObject(new Word("motive", Color.BLACK)));
		black.add(new SeedViewObject(new Word("bomer", Color.BLACK)));
		black.add(new SeedViewObject(new Word("regrettable", Color.BLACK)));
		black.add(new SeedViewObject(new Word("curse", Color.BLACK)));
		colorWordMap.put(Color.BLACK, black);

		List<SeedViewObject> gray = new ArrayList<SeedViewObject>();
		gray.add(new SeedViewObject(new Word("saucepan", Color.GRAY)));
		gray.add(new SeedViewObject(new Word("coincide", Color.GRAY)));
		gray.add(new SeedViewObject(new Word("aerodynamics", Color.GRAY)));
		colorWordMap.put(Color.GRAY, gray);

		List<SeedViewObject> yellow = new ArrayList<SeedViewObject>();
		yellow.add(new SeedViewObject(new Word("motive", Color.YELLOW)));
		yellow.add(new SeedViewObject(new Word("ditty", Color.YELLOW)));
		colorWordMap.put(Color.YELLOW, yellow);

		List<SeedViewObject> brown = new ArrayList<SeedViewObject>();
		Color brownColor = new Color(156, 93, 82);
		brown.add(new SeedViewObject(new Word("saddle", brownColor)));
		brown.add(new SeedViewObject(new Word("telephone", brownColor)));
		colorWordMap.put(Color.WHITE, white);

		List<SeedViewObject> pink = new ArrayList<SeedViewObject>();
		pink.add(new SeedViewObject(new Word("coincide", Color.PINK)));
		pink.add(new SeedViewObject(new Word("buss", Color.PINK)));
		colorWordMap.put(Color.PINK, pink);

		List<SeedViewObject> red = new ArrayList<SeedViewObject>();
		red.add(new SeedViewObject(new Word("assail", Color.RED)));
		red.add(new SeedViewObject(new Word("wrap", Color.RED)));
		red.add(new SeedViewObject(new Word("mangle", Color.RED)));
		red.add(new SeedViewObject(new Word("buss", Color.RED)));
		colorWordMap.put(Color.RED, red);

		//

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

			List<SeedViewObject> seeds = colorWordMap.get(cce.getColor());

			if (seeds != null)
			{
				for (SeedViewObject word : seeds)
				{
					seedListModel.addElement(word);
				}
			}

			seedList.setModel(seedListModel);
		}

	}
}