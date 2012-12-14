/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Component;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import nl.naiaden.ahci.poetrist.gui.SeedCellListRenderer;
import nl.naiaden.ahci.poetrist.gui.TransferableSeed;
import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * 
 * @author Ding
 * @author louis
 * 
 */
public class ColorSelectionPanel extends JPanel implements DragSourceListener, DragGestureListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313111916626939259L;

	private List<SeedViewObject> blackWords = null;
	private List<SeedViewObject> greyWords = null;
	private List<SeedViewObject> yellowWords = null;
	private List<SeedViewObject> brownWords = null;
	private List<SeedViewObject> pinkWords = null;
	private List<SeedViewObject> redWords = null;
	private List<SeedViewObject> whiteWords = null;
	private List<SeedViewObject> orangeWords = null;
	private List<SeedViewObject> blueWords = null;
	private List<SeedViewObject> greenWords = null;

	private JButton blackButton = null;
	private JButton greyButton = null;
	private JButton yellowButton = null;
	private JButton brownButton = null;
	private JButton pinkButton = null;
	private JButton redButton = null;
	private JButton whiteButton = null;
	private JButton orangeButton = null;
	private JButton blueButton = null;
	private JButton greenButton = null;
	
	DefaultListModel model1 = new DefaultListModel();
	JList wordList = null;

	// DefaultListModel model2 = new DefaultListModel();
	// JList wordList2 = new JList(model2);
	
	
	public ColorSelectionPanel(){
		blackWords = new ArrayList<SeedViewObject>();
		greyWords = new ArrayList<SeedViewObject>();
		yellowWords = new ArrayList<SeedViewObject>();
		brownWords = new ArrayList<SeedViewObject>();
		pinkWords = new ArrayList<SeedViewObject>();
		redWords = new ArrayList<SeedViewObject>();
		whiteWords = new ArrayList<SeedViewObject>();
		orangeWords = new ArrayList<SeedViewObject>();
		blueWords = new ArrayList<SeedViewObject>();
		greenWords = new ArrayList<SeedViewObject>();
		
		Color brown = new Color(156, 93, 82);

		ButtonListener bl = new ButtonListener();
		blackButton = new ColorSelectionButton(Color.BLACK, bl);
		greyButton = new ColorSelectionButton(Color.GRAY, bl);
		yellowButton = new ColorSelectionButton(Color.YELLOW, bl);
		brownButton = new ColorSelectionButton(brown, bl);
		pinkButton = new ColorSelectionButton(Color.PINK, bl);
		redButton = new ColorSelectionButton(Color.RED, bl);
		whiteButton = new ColorSelectionButton(Color.WHITE, bl);
		orangeButton = new ColorSelectionButton(Color.ORANGE, bl);
		blueButton = new ColorSelectionButton(Color.BLUE, bl);
		greenButton = new ColorSelectionButton(Color.GREEN, bl);



		wordList = new JList();
		wordList.setDragEnabled(true);
		// WordTransferHandler wth = new WordTransferHandler();
		// this.setTransferHandler(new SeedTransferHandler());
		wordList.setTransferHandler(new TransferHandler()
		{
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

			@Override
			public int getSourceActions(JComponent c)
			{
				return COPY;
				// COPY MOVE COPY_OR_MOVE same problem :)
			}
		});
		wordList.setModel(model1);
		wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wordList.setCellRenderer(new SeedCellListRenderer());
		
		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(wordList, DnDConstants.ACTION_COPY, this);

		// MouseInputAdapter dnd = new MouseInputAdapter() {
		//
		// @Override
		// public void mousePressed(MouseEvent e) {
		// // wth.exportAsDrag(wordList, e, TransferHandler.COPY);
		// System.out.println("HALLO DAAR?");
		// }
		// };
		// wordList.addMouseMotionListener(dnd);
		

		blackWords.add(new SeedViewObject(new Word("motive", Color.BLACK)));
		blackWords.add(new SeedViewObject(new Word("bomer", Color.BLACK)));
		blackWords.add(new SeedViewObject(new Word("regrettable", Color.BLACK)));
		blackWords.add(new SeedViewObject(new Word("curse", Color.BLACK)));

		greyWords.add(new SeedViewObject(new Word("saucepan", Color.GRAY)));
		greyWords.add(new SeedViewObject(new Word("coincide", Color.GRAY)));
		greyWords.add(new SeedViewObject(new Word("aerodynamics", Color.GRAY)));

		yellowWords.add(new SeedViewObject(new Word("motive", Color.YELLOW)));
		yellowWords.add(new SeedViewObject(new Word("ditty", Color.YELLOW)));

		brownWords.add(new SeedViewObject(new Word("saddle", brown)));
		brownWords.add(new SeedViewObject(new Word("telephone", brown)));

		pinkWords.add(new SeedViewObject(new Word("coincide", Color.PINK)));
		pinkWords.add(new SeedViewObject(new Word("buss", Color.PINK)));

		redWords.add(new SeedViewObject(new Word("assail", Color.RED)));
		redWords.add(new SeedViewObject(new Word("wrap", Color.RED)));
		redWords.add(new SeedViewObject(new Word("mangle", Color.RED)));
		redWords.add(new SeedViewObject(new Word("buss", Color.RED)));

		whiteWords.add(new SeedViewObject(new Word("tableware", Color.WHITE)));
		whiteWords.add(new SeedViewObject(new Word("transcendental", Color.WHITE)));
		whiteWords.add(new SeedViewObject(new Word("herewith", Color.WHITE)));
		whiteWords.add(new SeedViewObject(new Word("anterior", Color.WHITE)));

		orangeWords.add(new SeedViewObject(new Word("due", Color.ORANGE)));

		blueWords.add(new SeedViewObject(new Word("ditty", Color.BLUE)));

		greenWords.add(new SeedViewObject(new Word("garden", Color.GREEN)));
		
		GridLayout layout = new GridLayout(1,3);
		setLayout(layout);
		
		GridLayout leftLayout  = new GridLayout(10,1);
		JPanel leftPanel = new JPanel(leftLayout);
		GridLayout middleLayout  = new GridLayout(1,1);
		JPanel middlePanel = new JPanel(middleLayout);
		// GridLayout rightLayout = new GridLayout(1,1);
		// JPanel rightPanel = new JPanel(rightLayout);
		
		leftPanel.add(blackButton);
		leftPanel.add(greyButton);
		leftPanel.add(yellowButton);
		leftPanel.add(brownButton);
		leftPanel.add(pinkButton);
		leftPanel.add(redButton);
		leftPanel.add(whiteButton);
		leftPanel.add(orangeButton);
		leftPanel.add(blueButton);
		leftPanel.add(greenButton);
		


		// wordList2.setDragEnabled(true);
		middlePanel.add(wordList);
		// rightPanel.add(wordList2);
		
		add(leftPanel);
		add(middlePanel);
		// add(rightPanel);
	}
	
public class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{	int i;
			model1.clear();
			if (e.getSource() == blackButton)
			{
				for (SeedViewObject word : blackWords)
				{
					model1.addElement(word);
				}

			} else if (e.getSource() == greyButton)
			{
				for (SeedViewObject word : greyWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == yellowButton)
			{
				for (SeedViewObject word : yellowWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == brownButton)
			{
				for (SeedViewObject word : brownWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == pinkButton)
			{
				for (SeedViewObject word : pinkWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == redButton)
			{
				for (SeedViewObject word : redWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == whiteButton)
			{
				for (SeedViewObject word : whiteWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == orangeButton)
			{
				for (SeedViewObject word : orangeWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == blueButton)
			{
				for (SeedViewObject word : blueWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == greenButton)
			{
				for (SeedViewObject word : greenWords)
				{
					model1.addElement(word);
				}
			}

			wordList.setModel(model1);
		}
	}



	@Override
	public void dragDropEnd(DragSourceDropEvent dsde)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DragSourceEvent dse)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DragSourceDragEvent dsde)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0)
	{

		// arg0.startDrag(null, new TransferableSeed(new SeedViewObject(new
		// Word("test", Color.CYAN))));

	}
}
