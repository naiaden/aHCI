package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import nl.naiaden.ahci.poetrist.lexicon.Word;

public class WordSearchPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7209291487465820315L;

	private JTextField inputField = null;
	private Word searchWord = null;

	private ColorOptionPanel colorOptionPanel = null;
	private SeedListPanel seedListPanel = null;

	class InputFieldTextActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		}
	}

	class InputTextFieldDocumentListener implements DocumentListener
	{
		public void updateLog(DocumentEvent e, String action)
		{
			searchWord = new Word(inputField.getText());
			colorOptionPanel.setSearchWord(searchWord);
			colorOptionPanel.initialise();
		}

		@Override
		public void insertUpdate(DocumentEvent arg0)
		{
			updateLog(arg0, "inserted into");
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0)
		{
			updateLog(arg0, "removed from");
			
		}

		@Override
		public void changedUpdate(DocumentEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	}

	public WordSearchPanel()
	{
		colorOptionPanel = new ColorOptionPanel();
		seedListPanel = new SeedListPanel();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));

		inputField = new JTextField();
		inputField.addActionListener(new InputFieldTextActionListener());
		inputField.getDocument().addDocumentListener(new InputTextFieldDocumentListener());

		add(inputField, BorderLayout.PAGE_START);
		add(colorOptionPanel, BorderLayout.SOUTH);
		add(seedListPanel, BorderLayout.EAST);

		colorOptionPanel.addEventListener(seedListPanel);
	}

}
