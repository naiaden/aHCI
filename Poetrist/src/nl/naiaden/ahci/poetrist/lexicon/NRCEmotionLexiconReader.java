/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author louis
 *
 */
public class NRCEmotionLexiconReader implements LexiconReader
{

	public static void main(String args[])
	{
		NRCEmotionLexiconReader emotionLexicon = new NRCEmotionLexiconReader();

		try
		{
			emotionLexicon.read(new File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));

			System.out.println("Number of words: " + AssociationFactory.getWords().size());
			System.out.println("Number of senses: " + AssociationFactory.getSenses().size());
			System.out.println("Number of colors: " + AssociationFactory.getColors().size());

			System.out.println("Number of emotions: " + AssociationFactory.getEmotions().size());

			for (WordEmotion we : AssociationFactory.getWordEmotions())
			{
				System.out.println(we.toString());
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void read(File lexiconFile) throws IOException
	{
		FileInputStream fis = new FileInputStream(lexiconFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

		String line;

		int countDividerLines = 0;
		while ((line = br.readLine()) != null)
		{
			if (line.startsWith("............"))
			{
				++countDividerLines;
			}

			if (countDividerLines == 2)
			{
				break;
			}
		}

		while ((line = br.readLine()) != null)
		{
			String[] elements = line.split("\t");
			if (elements.length > 2)
			{
				AssociationFactory.addWordEmotion(new WordEmotion(new Word(elements[0]), new Emotion(elements[1]), elements[2].equals("1") ? true : false));
			}
		}
	}

}
