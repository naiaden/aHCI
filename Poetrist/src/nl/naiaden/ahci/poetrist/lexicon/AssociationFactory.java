/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Ding (I replaced some of his classes)
 * @author louis
 * 
 */
public class AssociationFactory
{
	private static List<Word> words = new ArrayList<Word>();
	private static List<Emotion> emotions = new ArrayList<Emotion>();
	private static List<ColorName> colors = new ArrayList<ColorName>();
	private static List<Sense> senses = new ArrayList<Sense>();

	private static List<WordColor> wordColors = new ArrayList<WordColor>();
	private static List<WordEmotion> wordEmotions = new ArrayList<WordEmotion>();
	private static List<WordSense> wordSenses = new ArrayList<WordSense>();

	/**
	 * Returns the n most similar words to a given word.
	 * @param word The input word.
	 * @param n The number of returned similar words. If n is greater than the total number of words, n is considered to be the number of words.
	 * @return A list of size n with words similar to the input word, sorted descendingly.
	 */
	public static List<Word> getNSimilarWords(Word word, int n)
	{
		List<Word> similarWords = new ArrayList<Word>();

		List<WordSimilarity> wordSimilarityList = wcfvs.getSimilarityList(word);

		Collections.sort(wordSimilarityList, new WordSimilarityComparator());
		wordSimilarityList = wordSimilarityList.subList(wordSimilarityList.size() - n, wordSimilarityList.size());

		for (WordSimilarity ws : wordSimilarityList)
		{
			similarWords.add(ws.lhs);
		}

		return similarWords;
	}

	public static void addWord(Word word)
	{
		if (!words.contains(word))
			words.add(word);

	}

	private static WordColorFeatureVectorSpace wcfvs = new WordColorFeatureVectorSpace();

	public static void printFeatureSpace()
	{
		wcfvs.printFeatureSpace();
	}

	public static List<Word> getWords()
	{
		return words;
	}

	public static List<Word> getWords(ColorName color)
	{
		List<Word> wordsForColors = new ArrayList<Word>();
		for (WordColor wordColor : wordColors)
		{
			if (wordColor.getColor().equals(color))
			{
				wordsForColors.add(wordColor.getWord());
			}
		}

		return wordsForColors;
	}

	public static List<Word> getWords(Emotion emotion)
	{
		List<Word> wordsForEmotion = new ArrayList<Word>();
		for (WordEmotion wordEmotion : wordEmotions)
		{
			if (wordEmotion.getEmotion().equals(emotion))
			{
				wordsForEmotion.add(wordEmotion.getWord());
			}
		}

		return wordsForEmotion;
	}

	public static List<Word> getSenses(Sense sense)
	{
		List<Word> wordsForSense = new ArrayList<Word>();
		for (WordSense wordSense : wordSenses)
		{
			if (wordSense.getSense().equals(sense))
			{
				wordsForSense.add(wordSense.getWord());
			}
		}

		return wordsForSense;
	}

	public static void addEmotion(Emotion emotion)
	{
		if (!emotions.contains(emotion))
			emotions.add(emotion);
	}

	public static List<Emotion> getEmotions()
	{
		return emotions;
	}

	public static List<Emotion> getEmotions(Word word)
	{
		List<Emotion> emotionsForWord = new ArrayList<Emotion>();
		for (WordEmotion wordEmotion : wordEmotions)
		{
			if (wordEmotion.getWord().equals(word))
			{
				emotionsForWord.add(wordEmotion.getEmotion());
			}
		}

		return emotionsForWord;
	}

	public static void addColor(ColorName color)
	{
		if (!colors.contains(color))
			colors.add(color);
	}

	public static List<ColorName> getColors()
	{
		return colors;
	}

	public static List<ColorName> getColors(Word word)
	{
		List<ColorName> wordColorsForWord = new ArrayList<ColorName>();
		for (WordColor wordColor : wordColors)
		{
			if (wordColor.getWord().equals(word))
			{
				wordColorsForWord.add(wordColor.getColor());
			}
		}

		return wordColorsForWord;
	}

	public static void addSense(Sense sense)
	{
		if (!senses.contains(sense))
			senses.add(sense);
	}

	public static List<Sense> getSenses()
	{
		return senses;
	}

	//

	public static void addWordColor(WordColor wordColor)
	{
		addWord(wordColor.getWord());
		addColor(wordColor.getColor());

		wcfvs.add(wordColor);

		if (!wordColors.contains(wordColor))
			wordColors.add(wordColor);
	}

	public static List<WordColor> getWordColors()
	{
		return wordColors;
	}

	public static List<WordColor> getWordColors(Word word)
	{
		List<WordColor> wordColorsForWord = new ArrayList<WordColor>();
		for (WordColor wordColor : wordColors)
		{
			if (wordColor.getWord().equals(word))
			{
				wordColorsForWord.add(wordColor);
			}
		}

		return wordColorsForWord;
	}

	public static List<WordColor> getWordColors(ColorName color)
	{
		List<WordColor> wordColorsForWord = new ArrayList<WordColor>();
		for (WordColor wordColor : wordColors)
		{
			if (wordColor.getColor().equals(color))
			{
				wordColorsForWord.add(wordColor);
			}
		}

		return wordColorsForWord;
	}

	//

	public static void addWordEmotion(WordEmotion wordEmotion)
	{
		addWord(wordEmotion.getWord());
		addEmotion(wordEmotion.getEmotion());

		if (!wordEmotions.contains(wordEmotion))
		{
			wordEmotions.add(wordEmotion);
		}
	}

	public static List<WordEmotion> getWordEmotions()
	{
		return wordEmotions;
	}

	public static List<WordEmotion> getWordEmotions(Word word)
	{
		List<WordEmotion> wordEmotionsForWord = new ArrayList<WordEmotion>();
		for (WordEmotion wordEmotion : wordEmotions)
		{
			if (wordEmotion.getWord().equals(word))
			{
				wordEmotionsForWord.add(wordEmotion);
			}
		}

		return wordEmotionsForWord;
	}

	public static List<WordEmotion> getWordEmotions(Emotion emotion)
	{
		List<WordEmotion> wordEmotionsForWord = new ArrayList<WordEmotion>();
		for (WordEmotion wordEmotion : wordEmotions)
		{
			if (wordEmotion.getEmotion().equals(emotion))
			{
				wordEmotionsForWord.add(wordEmotion);
			}
		}

		return wordEmotionsForWord;
	}

	//

	public static void addWordSense(WordSense wordSense)
	{
		addWord(wordSense.getWord());
		addSense(wordSense.getSense());

		if (!wordSenses.contains(wordSense))
		{
			wordSenses.add(wordSense);
		}
	}

	public static List<WordSense> getWordSenses()
	{
		return wordSenses;
	}

	public static List<WordSense> getWordSenses(Word word)
	{
		List<WordSense> wordSensesForWord = new ArrayList<WordSense>();
		for (WordSense wordSense : wordSenses)
		{
			if (wordSense.getWord().equals(word))
			{
				wordSensesForWord.add(wordSense);
			}
		}

		return wordSensesForWord;
	}

	public static List<WordSense> getWordSenses(Sense sense)
	{
		List<WordSense> wordSensesForWord = new ArrayList<WordSense>();
		for (WordSense wordSense : wordSenses)
		{
			if (wordSense.getSense().equals(sense))
			{
				wordSensesForWord.add(wordSense);
			}
		}

		return wordSensesForWord;
	}

	//

	public static List<ColorEmotion> getColorEmotions()
	{
		List<ColorEmotion> colorEmotions = new ArrayList<ColorEmotion>();

		for (Word word : AssociationFactory.getWords())
		{
			List<ColorName> wordColorAssociations = AssociationFactory.getColors(word);
			List<Emotion> wordEmotionAssocations = AssociationFactory.getEmotions(word);

			for (ColorName cn : wordColorAssociations)
			{
				for (Emotion e : wordEmotionAssocations)
				{
					colorEmotions.add(new ColorEmotion(cn, e));
				}
			}
		}

		return colorEmotions;
	}
}
