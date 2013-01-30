package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import nl.naiaden.ahci.poetrist.assocations.Emotions;
import nl.naiaden.ahci.poetrist.assocations.EmotionsToColors;
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

	private JTextArea textArea = null;
	private JButton submitButton = null;

	private boolean initialText = true;

	public PoemPanel()
	{

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(250, 200));

		textArea = new JTextArea("You can type your poetry here...");
		textArea.setFont(new Font("Serif",Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (initialText)
				{
					textArea.setText("");
					initialText = false;
				}
			}
		});

		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScrollPane.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createCompoundBorder(BorderFactory
.createTitledBorder("Poem Creation"), BorderFactory
		            .createEmptyBorder(5, 5, 5, 5)), areaScrollPane
		            .getBorder()));
		
		submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				StringToEmotion emotionAnalyzer = new StringToEmotion(textArea.getText());
				EmotionsToColors etc = new EmotionsToColors(emotionAnalyzer.getWeightedEmotions());

				// Emotions emotions = emotionAnalyzer.getEmotions();
				// EmotionsToColors etc = new
				// EmotionsToColors(emotions.getWeightedEmotions());
			}
		});

		add(areaScrollPane, BorderLayout.CENTER);
		add(submitButton, BorderLayout.SOUTH);
	}

}
