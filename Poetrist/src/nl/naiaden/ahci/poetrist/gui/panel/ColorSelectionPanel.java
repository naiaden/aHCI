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

public class ColorSelectionPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313111916626939259L;

	List<Word> blackWords = null;
	List<Word> greyWords = null;
	List<Word> yellowWords = null;
	List<Word> brownWords = null;
	List<Word> pinkWords = null;
	List<Word> redWords = null;
	List<Word> whiteWords = null;
	List<Word> orangeWords = null;
	List<Word> blueWords = null;
	List<Word> greenWords = null;

	JButton black= new JButton();
	JButton grey= new JButton();
	JButton yellow= new JButton();
	JButton brown= new JButton();
	JButton pink = new JButton();
	JButton red = new JButton();
	JButton white = new JButton();
	JButton orange = new JButton();
	JButton blue = new JButton();
	JButton green = new JButton();
	
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

		brownWords.add(new Word("saddle", new Color(156, 93, 82)));
		brownWords.add(new Word("telephone", new Color(156, 93, 82)));

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
		
		ButtonListener bl = new ButtonListener();
		GridLayout layout = new GridLayout(1,3);
		setLayout(layout);
		
		GridLayout leftLayout  = new GridLayout(10,1);
		JPanel leftPanel = new JPanel(leftLayout);
		GridLayout middleLayout  = new GridLayout(1,1);
		JPanel middlePanel = new JPanel(middleLayout);
		GridLayout rightLayout  = new GridLayout(1,1);
		JPanel rightPanel = new JPanel(rightLayout);
		
		black.setBackground(Color.BLACK);
		leftPanel.add(black);
		black.addActionListener(bl);
		
		grey.setBackground(Color.GRAY);
		leftPanel.add(grey);
		grey.addActionListener(bl);
		
		yellow.setBackground(Color.YELLOW);
		leftPanel.add(yellow);
		yellow.addActionListener(bl);
		
		Color myBrown = new Color(165,42,42);
		brown.setBackground(myBrown);
		leftPanel.add(brown);
		brown.addActionListener(bl);
		
		pink.setBackground(Color.PINK);
		leftPanel.add(pink);
		pink.addActionListener(bl);
		
		red.setBackground(Color.RED);
		leftPanel.add(red);
		red.addActionListener(bl);
		
		white.setBackground(Color.WHITE);
		leftPanel.add(white);
		white.addActionListener(bl);
		
		orange.setBackground(Color.ORANGE);
		leftPanel.add(orange);
		orange.addActionListener(bl);
		
		blue.setBackground(Color.BLUE);
		leftPanel.add(blue);
		blue.addActionListener(bl);
		
		green.setBackground(Color.GREEN);
		leftPanel.add(green);
		green.addActionListener(bl);
		
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
			if(e.getSource() == black){
				for (Word word : blackWords)
				{
					model1.addElement(word);
				}

			}else if(e.getSource() == grey){
				for (Word word : greyWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == yellow){
				for (Word word : yellowWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == brown){
				for (Word word : brownWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == pink){
				for (Word word : pinkWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == red){
				for (Word word : redWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == white){
				for (Word word : whiteWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == orange){
				for (Word word : orangeWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == blue){
				for (Word word : blueWords)
				{
					model1.addElement(word);
				}
			}else if(e.getSource() == green){
				for (Word word : greenWords)
				{
					model1.addElement(word);
				}
			}
		}
	}
}
