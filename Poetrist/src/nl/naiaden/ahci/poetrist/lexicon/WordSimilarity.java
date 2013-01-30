package nl.naiaden.ahci.poetrist.lexicon;

import java.io.Serializable;

public class WordSimilarity implements Serializable
{
	Word lhs;
	Word rhs;
	double similarity;

	public WordSimilarity(Word lhs, Word rhs, double similarity)
	{
		this.lhs = lhs;
		this.rhs = rhs;
		this.similarity = similarity;
	}
}