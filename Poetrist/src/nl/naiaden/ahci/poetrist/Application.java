/**
 * 
 */
package nl.naiaden.ahci.poetrist;

import java.io.File;
import java.io.IOException;
import java.util.Random;

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

	public static final LogWriter LOGWRITER = new LogWriter();
	
	public static final boolean deterministic = true;
	public static Random RANDOMGEN = new Random();

	/**
	 * @param args The input parameters.
	 */
	public static void main(String[] args) {
		
		if (Application.deterministic)
		{
			Application.LOGWRITER.system("Deterministic experiment started!");
			RANDOMGEN = new Random(1234);
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
		      public void run() {
				System.err.println("Shutting down");
				LOGWRITER.close();
		      }
		});

		NRCColorLexiconReader colorLexiconReader = new NRCColorLexiconReader();
		NRCEmotionLexiconReader emotionLexiconReader = new NRCEmotionLexiconReader();
		
		try
		{

			if (!AssociationFactory.readDataFromFile())
			{
				// colorLexiconReader.read(new
				// File("doc/WordColorLexicon_small.txt"));
				// emotionLexiconReader.read(new
				// File("doc/WordEmotionLexicon_small.txt"));

				colorLexiconReader.read(new File("doc/NRC-color-lexicon-senselevel-v0.92.txt"));
				emotionLexiconReader.read(new File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));

				AssociationFactory.saveDataToFile();
			}



			// colorLexiconReader.read(new
			// File("doc/NRC-color-lexicon-senselevel-v0.92.txt"));
			// emotionLexiconReader.read(new
			// File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));

			// // AssociationFactory.printFeatureSpace();
			// // AssociationFactory.getNSimilarWords(new Word("p"), 5);
			// System.out.println(AssociationFactory.getNSimilarWords(new
			// Word("love"), 5));
			// System.out.println(AssociationFactory.getNSimilarWords(new
			// Word("adore"), 5));
			//
			// // colorLexiconReader.read(new
			// // File("doc/NRC-color-lexicon-senselevel-v0.92.txt"));
			// // emotionLexiconReader.read(new
			// //
			// File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));
			
			Application.LOGWRITER.system(AssociationFactory.getWords().size() + " words");
			Application.LOGWRITER.system(AssociationFactory.getColors().size() + " colors");
			Application.LOGWRITER.system(AssociationFactory.getEmotions().size() + " emotions");

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

	private static int paintingNumber = 0;

	public static int GetPaintingNumber()
	{
		return paintingNumber++;
	}

}
