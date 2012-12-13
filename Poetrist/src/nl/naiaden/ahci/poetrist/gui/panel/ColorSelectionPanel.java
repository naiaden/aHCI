/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.gui.WordCellListRenderer;
import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * 
 * @author Ding
 * @author louis
 * 
 */
public class ColorSelectionPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313111916626939259L;

	private List<Word> blackWords = null;
	private List<Word> greyWords = null;
	private List<Word> yellowWords = null;
	private List<Word> brownWords = null;
	private List<Word> pinkWords = null;
	private List<Word> redWords = null;
	private List<Word> whiteWords = null;
	private List<Word> orangeWords = null;
	private List<Word> blueWords = null;
	private List<Word> greenWords = null;

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
	DefaultListModel model2 = new DefaultListModel();
	JList wordList2 = new JList(model2);
	
	
	public ColorSelectionPanel(){
		blackWords = new ArrayList<Word>();
		greyWords = new ArrayList<Word>();
		yellowWords = new ArrayList<Word>();
		brownWords = new ArrayList<Word>();
		pinkWords = new ArrayList<Word>();
		redWords = new ArrayList<Word>();
		whiteWords = new ArrayList<Word>();
		orangeWords = new ArrayList<Word>();
		blueWords = new ArrayList<Word>();
		greenWords = new ArrayList<Word>();
		
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

		wordList = new JList(model1);
		wordList.setCellRenderer(new WordCellListRenderer());

		blackWords.add(new Word("motive", Color.BLACK));
		blackWords.add(new Word("bomer", Color.BLACK));
		blackWords.add(new Word("regrettable", Color.BLACK));
		blackWords.add(new Word("curse", Color.BLACK));

		greyWords.add(new Word("saucepan", Color.GRAY));
		greyWords.add(new Word("coincide", Color.GRAY));
		greyWords.add(new Word("aerodynamics", Color.GRAY));

		yellowWords.add(new Word("motive", Color.YELLOW));
		yellowWords.add(new Word("ditty", Color.YELLOW));

		brownWords.add(new Word("saddle", brown));
		brownWords.add(new Word("telephone", brown));

		pinkWords.add(new Word("coincide", Color.PINK));
		pinkWords.add(new Word("buss", Color.PINK));

		redWords.add(new Word("assail", Color.RED));
		redWords.add(new Word("wrap", Color.RED));
		redWords.add(new Word("mangle", Color.RED));
		redWords.add(new Word("buss", Color.RED));

		whiteWords.add(new Word("tableware", Color.WHITE));
		whiteWords.add(new Word("transcendental", Color.WHITE));
		whiteWords.add(new Word("herewith", Color.WHITE));
		whiteWords.add(new Word("anterior", Color.WHITE));

		orangeWords.add(new Word("due", Color.ORANGE));

		blueWords.add(new Word("ditty", Color.BLUE));

		greenWords.add(new Word("garden", Color.GREEN));
		
		GridLayout layout = new GridLayout(1,3);
		setLayout(layout);
		
		GridLayout leftLayout  = new GridLayout(10,1);
		JPanel leftPanel = new JPanel(leftLayout);
		GridLayout middleLayout  = new GridLayout(1,1);
		JPanel middlePanel = new JPanel(middleLayout);
		GridLayout rightLayout  = new GridLayout(1,1);
		JPanel rightPanel = new JPanel(rightLayout);
		
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
		
		wordList.setDragEnabled(true);
		wordList2.setDragEnabled(true);
		middlePanel.add(wordList);
		rightPanel.add(wordList2);
		
		add(leftPanel);
		add(middlePanel);
		add(rightPanel);
	}
	
public class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{	int i;
			model1.clear();
			if (e.getSource() == blackButton)
			{
				for (Word word : blackWords)
				{
					model1.addElement(word);
				}

			} else if (e.getSource() == greyButton)
			{
				for (Word word : greyWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == yellowButton)
			{
				for (Word word : yellowWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == brownButton)
			{
				for (Word word : brownWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == pinkButton)
			{
				for (Word word : pinkWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == redButton)
			{
				for (Word word : redWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == whiteButton)
			{
				for (Word word : whiteWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == orangeButton)
			{
				for (Word word : orangeWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == blueButton)
			{
				for (Word word : blueWords)
				{
					model1.addElement(word);
				}
			} else if (e.getSource() == greenButton)
			{
				for (Word word : greenWords)
				{
					model1.addElement(word);
				}
			}
		}
	}
}
