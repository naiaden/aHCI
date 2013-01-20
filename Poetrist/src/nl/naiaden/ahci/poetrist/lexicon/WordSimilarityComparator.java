package nl.naiaden.ahci.poetrist.lexicon;

import java.util.Comparator;

public class WordSimilarityComparator implements Comparator<WordSimilarity>
{
	@Override
	public int compare(WordSimilarity o1, WordSimilarity o2)
	{
		return Double.valueOf(o1.similarity).compareTo(Double.valueOf(o2.similarity));
		// return (int) (o1.similarity - o2.similarity);
		// if (o1.similarity > o2.similarity)
		// return 1;
		// else if (o1.similarity == o2.similarity)
		// return 0;
		// else
		// return -1;
	}
}