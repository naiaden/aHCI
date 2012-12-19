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
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import nl.naiaden.ahci.poetrist.gui.SeedCellListRenderer;
import nl.naiaden.ahci.poetrist.gui.dnd.TransferableSeed;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedEvent;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedListener;
import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;
import nl.naiaden.ahci.poetrist.lexicon.Word;
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

//		add(seedList);
		scrollPane = new JScrollPane(seedList);
		add(scrollPane);

		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(seedList, DnDConstants.ACTION_COPY, this);

		// just temporarily
		// in a later stage these will be requested from the WordColorFactory

//		List<SeedViewObject> green = new ArrayList<SeedViewObject>();
//		green.add(new SeedViewObject(new WordColor(new Word("garden"), new ColorName("green"))));
//		colorWordMap.put(Color.GREEN, green);
//
//		List<SeedViewObject> blue = new ArrayList<SeedViewObject>();
//		blue.add(new SeedViewObject(new WordColor(new Word("ditty"), new ColorName("BLUE"))));
//		colorWordMap.put(Color.BLUE, blue);
//
//		List<SeedViewObject> orange = new ArrayList<SeedViewObject>();
//		orange.add(new SeedViewObject(new WordColor(new Word("due"), new ColorName("ORANGE"))));
//		colorWordMap.put(Color.ORANGE, orange);
//
//		List<SeedViewObject> white = new ArrayList<SeedViewObject>();
//		white.add(new SeedViewObject(new WordColor(new Word("anterior"), new ColorName("WHITE"))));
//		white.add(new SeedViewObject(new WordColor(new Word("herewith"), new ColorName("WHITE"))));
//		white.add(new SeedViewObject(new WordColor(new Word("transcendental"), new ColorName("WHITE"))));
//		white.add(new SeedViewObject(new WordColor(new Word("tableware"), new ColorName("WHITE"))));
//		colorWordMap.put(Color.WHITE, white);
//
//		List<SeedViewObject> black = new ArrayList<SeedViewObject>();
//		black.add(new SeedViewObject(new WordColor(new Word("motive"), new ColorName("BLACK"))));
//		black.add(new SeedViewObject(new WordColor(new Word("bomer"), new ColorName("BLACK"))));
//		black.add(new SeedViewObject(new WordColor(new Word("regrettable"), new ColorName("BLACK"))));
//		black.add(new SeedViewObject(new WordColor(new Word("curse"), new ColorName("BLACK"))));
//		colorWordMap.put(Color.BLACK, black);
//
//		List<SeedViewObject> gray = new ArrayList<SeedViewObject>();
//		gray.add(new SeedViewObject(new WordColor(new Word("saucepan"), new ColorName("GRAY"))));
//		gray.add(new SeedViewObject(new WordColor(new Word("coincide"), new ColorName("GRAY"))));
//		gray.add(new SeedViewObject(new WordColor(new Word("aerodynamics"), new ColorName("GRAY"))));
//		colorWordMap.put(Color.GRAY, gray);
//
//		List<SeedViewObject> yellow = new ArrayList<SeedViewObject>();
//		yellow.add(new SeedViewObject(new WordColor(new Word("motive"), new ColorName("YELLOW"))));
//		yellow.add(new SeedViewObject(new WordColor(new Word("ditty"), new ColorName("YELLOW"))));
//		colorWordMap.put(Color.YELLOW, yellow);
//
//		List<SeedViewObject> brown = new ArrayList<SeedViewObject>();
//		Color brownColor = new Color(156, 93, 82);
//		brown.add(new SeedViewObject(new WordColor(new Word("saddle"), new ColorName("brown"))));
//		brown.add(new SeedViewObject(new WordColor(new Word("telephone"), new ColorName("brown"))));
//		colorWordMap.put(Color.WHITE, white);
//
//		List<SeedViewObject> pink = new ArrayList<SeedViewObject>();
//		pink.add(new SeedViewObject(new WordColor(new Word("coincide"), new ColorName("PINK"))));
//		pink.add(new SeedViewObject(new WordColor(new Word("buss"), new ColorName("PINK"))));
//		colorWordMap.put(Color.PINK, pink);
//
//		List<SeedViewObject> red = new ArrayList<SeedViewObject>();
//		red.add(new SeedViewObject(new WordColor(new Word("assail"), new ColorName("RED"))));
//		red.add(new SeedViewObject(new WordColor(new Word("wrap"), new ColorName("RED"))));
//		red.add(new SeedViewObject(new WordColor(new Word("mangle"), new ColorName("RED"))));
//		red.add(new SeedViewObject(new WordColor(new Word("buss"), new ColorName("RED"))));
//		colorWordMap.put(Color.RED, red);

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