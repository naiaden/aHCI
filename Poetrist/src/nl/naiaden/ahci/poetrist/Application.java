/**
 * 
 */
package nl.naiaden.ahci.poetrist;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import nl.naiaden.ahci.poetrist.gui.PoetristFrame;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.NRCColorLexiconReader;
import nl.naiaden.ahci.poetrist.lexicon.NRCEmotionLexiconReader;
import nl.naiaden.ahci.poetrist.stringtoemotion.StringToEmotion;

/**
 * @author louis
 *
 */
public class Application {

	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI()
	{
		PoetristFrame frame = new PoetristFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * @param args The input parameters.
	 */
	public static void main(String[] args) {
		
		NRCColorLexiconReader colorLexiconReader = new NRCColorLexiconReader();
		NRCEmotionLexiconReader emotionLexiconReader = new NRCEmotionLexiconReader();
		
		try
		{		
			colorLexiconReader.read(new File("doc/WordColorLexicon_small.txt"));
			emotionLexiconReader.read(new File("doc/WordEmotionLexicon_small.txt"));
			
			System.out.println(AssociationFactory.getWords().size() + " words");
			System.out.println(AssociationFactory.getColors().size() + " colors");
			System.out.println(AssociationFactory.getEmotions().size() + " emotions");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}

}
