package nl.naiaden.ahci.poetrist.gui.panel;

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
	
	private List<Word> similarWordList = null;
	
	public WordSearchPanelForTest(){
		searchField = new JTextField();
		
	}
	
	public List<Word> searchSimilarWord(Word word){
		similarWordList = AssociationFactory.getNSimilarWords(word, 10);
		return similarWordList;
	}
	
	public class InputFieldTextActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	public class InputTextFieldDocumentListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent arg0)
		{
			// TODO Auto-generated method stub
			searchWord = new Word(searchField.getText());
			searchSimilarWord(searchWord);
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
}
