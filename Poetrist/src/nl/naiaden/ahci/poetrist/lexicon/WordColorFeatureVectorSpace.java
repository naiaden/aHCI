package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class WordColorFeatureVectorSpace implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8628958143626409046L;
	private List<WordColorFeatureVector> featureVectors = new ArrayList<WordColorFeatureVector>();

	public void add(WordColor wordColor)
	{

		for (WordColorFeatureVector wcfv : featureVectors)
		{
			if (wcfv.word.equals(wordColor.getWord()))
			{
				wcfv.set(wordColor.getColor().getColor(), wordColor.getConfidence());
				return;
			}
		}

		featureVectors.add(new WordColorFeatureVector(wordColor));
	}

	public WordColorFeatureVector getWordColorFeatureVector(Word word)
	{
		for (WordColorFeatureVector wcfv : featureVectors)
		{
			if (wcfv.word.equals(word)) { return wcfv; }
		}

		return null;
	}

	public List<WordSimilarity> getSimilarityList(Word word)
	{
		List<WordSimilarity> similarityList = new ArrayList<WordSimilarity>();
		
		WordColorFeatureVector wcfv = getWordColorFeatureVector(word);
		if (wcfv != null) { return getSimilarityList(wcfv); }
		
		return similarityList;
	}

	public List<WordSimilarity> getSimilarityList(WordColorFeatureVector rhs)
	{
		List<WordSimilarity> similarityList = new ArrayList<WordSimilarity>();

		for (WordColorFeatureVector wcfv : featureVectors)
		{
			if (!wcfv.word.equals(rhs.word))
			{
				similarityList.add(new WordSimilarity(wcfv.word, rhs.word, wcfv.cosineSimilarity(rhs)));
			}
		}

		return similarityList;
	}

	public void printFeatureSpace()
	{
		System.out.println("Feature Space");
		for (WordColorFeatureVector wcfv : featureVectors)
		{
			System.out.println(wcfv.toString());
		}
	}
}