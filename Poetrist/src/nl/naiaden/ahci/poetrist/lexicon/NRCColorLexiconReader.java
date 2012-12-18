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

import nl.naiaden.ahci.poetrist.PoetristColor;

/**
 * Based on the LexiconReader class by Nelletor.
 * 
 * @author louis
 * 
 */
public class NRCColorLexiconReader implements LexiconReader
{

	public static void main(String args[])
	{
		NRCColorLexiconReader colorLexicon = new NRCColorLexiconReader();
		NRCEmotionLexiconReader emotionLexicon = new NRCEmotionLexiconReader();

		try
		{
			colorLexicon.read(new File("doc/NRC-color-lexicon-senselevel-v0.92.txt"));

			System.out.println("Number of words: " + AssociationFactory.getWords().size());
			System.out.println("Number of senses: " + AssociationFactory.getSenses().size());
			System.out.println("Number of colors: " + AssociationFactory.getColors().size());

			emotionLexicon.read(new File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));
			System.out.println("Number of emotions: " + AssociationFactory.getEmotions().size());

			System.out.println("Number of words: " + AssociationFactory.getWords().size());

			//

			for (ColorEmotion ce : AssociationFactory.getColorEmotions())
			{
				System.out.println(ce.toString());
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

		while ((line = br.readLine()) != null)
		{
			if (line.startsWith("............"))
			{
				break;
			}
		}

		while ((line = br.readLine()) != null)
		{
			String[] elements = line.split("\t");

			if (elements.length >= 3)
			{
				String[] wordSense = elements[0].split("--");

				Word word = new Word(wordSense[0]);
				AssociationFactory.addWord(word);

				String[] senses = wordSense[1].split(", ");
				for (String sense : senses)
				{
					AssociationFactory.addWordSense(new WordSense(word, new Sense(sense)));
				}

				String voteCountRepresentation = elements[2].substring(19);
				int votes = 0;
				if (!voteCountRepresentation.equals("None"))
				{
					Integer votesCount = Integer.parseInt(voteCountRepresentation);
					if (votesCount != null)
					{
						votes = votesCount.intValue();
					}
				}

				String totalVoteCountRepresentation = elements[3].substring(15);
				int totalVotes = 0;
				if (!totalVoteCountRepresentation.equals("None"))
				{
					Integer totalVotesCount = Integer.parseInt(totalVoteCountRepresentation);
					if (totalVotesCount != null)
					{
						totalVotes = totalVotesCount.intValue();
					}
				}

				String colorName = elements[1].substring(7);
				if (!colorName.equals("None"))
				{
					AssociationFactory.addWordColor(new WordColor(word, new ColorName(colorName), votes, totalVotes));
				}

			}
		}
	}

}
