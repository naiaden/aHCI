package nl.naiaden.ahci.poetrist.lexicon;

public class WordSimilarity
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