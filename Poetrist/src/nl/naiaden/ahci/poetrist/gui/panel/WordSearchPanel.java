package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nl.naiaden.ahci.poetrist.lexicon.Word;

public class WordSearchPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7209291487465820315L;

	private JTextField inputField = null;
	private JButton submitButton = null;
	private Word searchWord = null;
	
	private ColorOptionPanel colorOptionPanel = null;
	private SeedListPanel seedListPanel = null;

	public WordSearchPanel()
	{
		colorOptionPanel = new ColorOptionPanel();
		seedListPanel = new SeedListPanel();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));

		inputField = new JTextField();
		submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
				searchWord = new Word(inputField.getText());
				//colorOptionPanel = new ColorOptionPanel();
				colorOptionPanel.setSearchWord(searchWord);
				colorOptionPanel.initialise();
				
				
			}
		});
		
		add(inputField, BorderLayout.PAGE_START);
		add(submitButton,BorderLayout.CENTER);
		add(colorOptionPanel,BorderLayout.SOUTH);
		add(seedListPanel,BorderLayout.EAST);
		
		colorOptionPanel.addEventListener(seedListPanel);
	}

	
	
}
