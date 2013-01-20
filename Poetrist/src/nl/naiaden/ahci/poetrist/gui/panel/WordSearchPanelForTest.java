package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.Word;

public class WordSearchPanelForTest extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8371817152276515360L;
	
	private Word searchWord = null;
	private JTextField searchField = null;
	private JScrollPane scrollPane = null;
	private JList similarWords = null;
	private DefaultListModel similarWordsModel = new DefaultListModel();
	private GridLayout layout = null;
	
	
	//private List<Word> similarWordList = null;
	
	public WordSearchPanelForTest(){
		searchField = new JTextField();
		searchField.addActionListener(new InputFieldTextActionListener());
		searchField.getDocument().addDocumentListener(new InputTextFieldDocumentListener());
		similarWords = new JList();
		layout = new GridLayout(0,1);
		setLayout(layout);
		scrollPane = new JScrollPane(similarWords);
		
		add(searchField);
		add(scrollPane);
		
		initialise();
	}
	
	public void initialise(){
		similarWords.setModel(similarWordsModel);
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
			Document doc = (Document)e.getDocument();
			int wordLength = doc.getLength();
			
			try
			{
				searchWord = new Word(doc.getText(0, wordLength));
				System.out.println(searchWord.getWord());
				List<Word> wordList = AssociationFactory.getNSimilarWords(searchWord, 10);
				for (Word word : wordList){
					similarWordsModel.addElement(word);
					System.out.println("Found word:" + word.getWord());
				}
			} catch (BadLocationException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
