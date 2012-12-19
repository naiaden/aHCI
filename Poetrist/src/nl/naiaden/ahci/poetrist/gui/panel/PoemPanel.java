package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import nl.naiaden.ahci.poetrist.assocations.Emotions;
import nl.naiaden.ahci.poetrist.assocations.StringToEmotion;

/**
 * 
 * @author Ding
 * 
 */
public class PoemPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -916168874765976242L;

	private JTextPane inputPane = null;
	private JButton submitButton = null;

	public PoemPanel()
	{

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));

		inputPane = new JTextPane();
		submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				StringToEmotion emotionAnalyzer = new StringToEmotion(inputPane.getText());
				
				Emotions emotions = emotionAnalyzer.getEmotions();

			}
		});

		add(inputPane, BorderLayout.CENTER);
		add(submitButton, BorderLayout.SOUTH);
	}

}
