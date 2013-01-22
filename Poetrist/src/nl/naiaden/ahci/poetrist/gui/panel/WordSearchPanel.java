package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import nl.naiaden.ahci.poetrist.gui.model.FlowerFactory;
import nl.naiaden.ahci.poetrist.gui.view.FlowerViewObject;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.Word;
import nl.naiaden.ahci.poetrist.lexicon.WordColor;


/**
 * @author Ding
 *
 */
public class WordSearchPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8371817152276515360L;
	
	private GardenPanel dropPanel = new GardenPanel();
	
	private Word searchWord = null;
	private int number = 10;
	
	private JTextField searchField = null;
	private JTextField numberField = null;
	
	private JLabel searchFieldLabel = null;
	private JLabel numberFieldLabel = null;
	private JLabel wordsResult = null;
	
	private JScrollPane scrollPane = null;
	
	private JList similarWords = null;
	private DefaultListModel similarWordsModel = new DefaultListModel();
	private GridBagLayout layout = null;
	private GridBagConstraints c = null;
	
	
	//private List<Word> similarWordList = null;
	
	public WordSearchPanel(){
		layout = new GridBagLayout();
		c = new GridBagConstraints();
		setLayout(layout);
		
		c.fill = GridBagConstraints.BOTH;
		
		
		numberFieldLabel = new JLabel("Number of similar words:  ");
		numberFieldLabel.setLabelFor(numberField);
		
		c.gridx = 0;
		c.gridy = 0;
		add(numberFieldLabel,c);
		
		numberField = new JTextField("10");
		numberField.addActionListener(new InputFieldTextActionListener());
		numberField.getDocument().addDocumentListener(new InputTextFieldDocumentListener());
		
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 30;
		add(numberField,c);
		
		
		searchFieldLabel = new JLabel("Word:  ");
		searchFieldLabel.setLabelFor(searchField);
		
		c.gridx = 0;
		c.gridy = 1;
		add(searchFieldLabel,c);
		
		searchField = new JTextField();
		searchField.addActionListener(new InputFieldTextActionListener());
		searchField.getDocument().addDocumentListener(new InputTextFieldDocumentListener());
		c.gridx = 1;
		c.gridy = 1;
		add(searchField,c);
		
		
		wordsResult = new JLabel("Similar words list:  ");
		wordsResult.setLabelFor(searchField);
		wordsResult.setLabelFor(scrollPane);
		
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 20;
		add(wordsResult,c);
		
		similarWords = new JList();
		scrollPane = new JScrollPane(similarWords);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.ipady = 100;
		add(scrollPane,c);
		
		setBorder(BorderFactory.createCompoundBorder(
		       BorderFactory.createTitledBorder("Similar Words Search"), BorderFactory
		           .createEmptyBorder(5, 5, 5, 5)));
		
		initialise();
	}
	
	public void initialise(){
		similarWords.setModel(similarWordsModel);
		similarWords.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				if (evt.getClickCount() ==2){
					String selectedWord = similarWords.getSelectedValue().toString();
					JOptionPane.showMessageDialog(similarWords, "Word  " + "\"" + selectedWord + 
							"\"" + "  has been picked into the garden");
					WordColor seed = AssociationFactory.getWordColors(new Word(selectedWord)).get(0);
					FlowerViewObject flower = new FlowerViewObject(FlowerFactory.createFlower(seed),251,250,150,7);
					System.out.println(flower);
					dropPanel.addFlower(flower);
				}
			}
		});
	}
	
	public class InputFieldTextActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	public class InputTextFieldDocumentListener implements DocumentListener{
		
		@Override
		public void changedUpdate(DocumentEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent e)
		{
			// TODO Auto-generated method stub
			updateLog(e,"inserted into\n");
		}

		@Override
		public void removeUpdate(DocumentEvent e)
		{
			// TODO Auto-generated method stub
			updateLog(e, "removed from\n");
		}
		
		public void updateLog(DocumentEvent e, String action){
			similarWordsModel.clear();
			
			if (!numberField.getText().equals("")){
				number  = Integer.parseInt(numberField.getText());
			}
			
			searchWord = new Word(searchField.getText());
			List<Word> wordList = AssociationFactory.getNSimilarWords(searchWord, number);
			for (Word word : wordList){
				similarWordsModel.addElement(word);
				similarWords.setModel(similarWordsModel);
			}
		}
		
	}
}
