package nl.naiaden.ahci.poetrist.assocations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.Emotion;
import nl.naiaden.ahci.poetrist.lexicon.LexiconReader;
import nl.naiaden.ahci.poetrist.lexicon.NRCColorLexiconReader;
import nl.naiaden.ahci.poetrist.lexicon.NRCEmotionLexiconReader;
import nl.naiaden.ahci.poetrist.lexicon.Word;
import nl.naiaden.ahci.poetrist.lexicon.WordEmotion;

/**
 * accepts the raw poem, filters out the punctuationm and takes all the relevant
 * words and makes an Emotions class which contains all the necessary
 * information about the emotional value of the raw string.
 * 
 * @author Stef Janssen
 * 
 */
public class StringToEmotion
{
	// the list of words that are in the poem
	// private String[] wordList;
	private Emotions emotions = new Emotions();
	// LexiconReader lr;
	// private List<Word> words = new ArrayList<Word>();

	public static void main(String args[])
	{
		NRCColorLexiconReader colorLexiconReader = new NRCColorLexiconReader();
		NRCEmotionLexiconReader emotionLexiconReader = new NRCEmotionLexiconReader();

		try
		{
			colorLexiconReader.read(new File("doc/WordColorLexicon_small.txt"));
			emotionLexiconReader.read(new File("doc/WordEmotionLexicon_small.txt"));

			// +++ anger: 0.3125
			// +++ disgust: 0.375
			// +++ fear: 0.3125
			// +++ negative: 0.625
			// +++ sadness: 0.4375
			// +++ surprise: 0.125

			// colorLexiconReader.read(new
			// File("doc/NRC-color-lexicon-senselevel-v0.92.txt"));
			// emotionLexiconReader.read(new
			// File("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt"));

			StringToEmotion ste = new StringToEmotion(input);
			EmotionsToColors etc = new EmotionsToColors(ste.getWeightedEmotions());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static String input = " Depression makes me feel pain\n" + "Depression makes me stupid\n" + "Depression makes me feel low\n" + "Depression makes me mad\n"
			+ "Depression makes me sad\n" + "Depression makes me forget world\n" + "Depression makes me tensed\n" + "Depression makes me lose self control\n"
			+ "Depression makes me hate everyone\n" + "Depression makes me think over and over\n" + "Depression makes me feel lonely\n" + "Depression makes me think wild\n"
			+ "Depression makes me worthless\n" + "Depression makes me sick\n" + "What does Depression give me?\n" + "When it runs high…\n"
			+ "It will make me Die - REST IN PEACE… ";

	/**
	 * constructor which is going to be actually used, input is the raw poem
	 * 
	 * @param text
	 */
	public StringToEmotion(String text)
	{
		System.out.println("Words in lexicon:");
		String[] words = text.split("\\s+");
		List<Word> wordsInLexicon = new ArrayList<Word>();
		for (String word : words)
		{
			Word lexiconWord = new Word(word);
			if (AssociationFactory.getWords().contains(lexiconWord))
			{
				wordsInLexicon.add(lexiconWord);
				System.out.println(lexiconWord);
			}
		}

		determineEmotions(wordsInLexicon);
	}

	private List<WeightedEmotion> weightedEmotions = null;

	public List<WeightedEmotion> getWeightedEmotions()
	{
		if (weightedEmotions == null)
		{
			System.err.println("DETERMINE EMOTIONS FIRST");
		}
		return weightedEmotions;
	}

	private void determineEmotions(List<Word> words)
	{
		for (Word word : words)
		{
			// // for (WordEmotion woE :
			// AssociationFactory.getWordEmotions(word))
			// // {
			// // System.out.println("--- " + woE);
			// // }
			// System.out.println("_-_ " + word);
			// System.out.println("_-> " +
			// AssociationFactory.getWordEmotions(word));

			emotions.add(AssociationFactory.getWordEmotions(word));

		}


		weightedEmotions = emotions.getWeightedEmotions();
		for (WeightedEmotion we : weightedEmotions)
		{
			if (we.getAverageWeight() > 0)
			{
				System.out.println("+++ " + we.getEmotionType() + ": " + we.getAverageWeight());
			}
		}

	}


	// /**
	// * loops through the list of words and checks whether the lexicon contains
	// * the word. If so, it adds the emotional value to the emotions class.
	// */
	// private void determineEmotions()
	// {
	// System.out.println("determining emotions");
	// for (String word : wordList)
	// for (Word w : words)
	// if (word.equals(w.getWord()))
	// {
	// // System.out.println("A relevant word: " + word); //for
	// // visualizing which words get chosen
	// emotions.addMagnitudes(AssociationFactory.getWordEmotions(w));
	// emotions.showMagnitudes();
	// // for(WordEmotion ww:
	// // AssociationFactory.getWordEmotions(w))
	// // System.out.println(ww.toString());
	//
	// }
	//
	// }

	// /**
	// * returns what words have been found in the poem
	// *
	// * @return
	// */
	// public String[] getText()
	// {
	// return wordList;
	// }

	/**
	 * returns the emotions class which holds all the information about the
	 * magnitudes.
	 * 
	 * @return
	 */
	public Emotions getEmotions()
	{
		return emotions;
	}

}
