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
import nl.naiaden.ahci.poetrist.lexicon.Word;

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

			// AssociationFactory.printFeatureSpace();
			AssociationFactory.getNSimilarWords(new Word("promise"), 5);
			System.out.println(AssociationFactory.getNSimilarWords(new Word("promise"), 5));

			// colorLexiconReader.read(new
			// File("doc/NRC-color-lexicon-senselevel-v0.92.txt"));
			// emotionLexiconReader.read(new
			// File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));
			
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
