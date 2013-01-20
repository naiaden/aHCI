/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.io.Serializable;

/**
 * @author Ding
 * @author louis
 * 
 */
public class WordColor implements LexiconEntry, Serializable
{
	private final Word word;
	private final ColorName color;

	private int votes;
	private int totalVotes;

	public WordColor(Word word, ColorName color)
	{
		this.word = word;
		this.color = color;
	}

	public WordColor(Word word, ColorName color, int votes, int totalVotes)
	{
		this.word = word;
		this.color = color;

		this.votes = votes;
		this.totalVotes = totalVotes;
	}

	public Word getWord()
	{
		return word;
	}

	public ColorName getColor()
	{
		return color;
	}

	public int getVotes()
	{
		return votes;
	}

	public double getConfidence()
	{
		return Double.valueOf(((double) votes) / totalVotes);
	}

	public int getTotalVotes()
	{
		return totalVotes;
	}

	public String toString()
	{
		return word.toString() + "--" + color.toString() + "[" + votes + "/" + totalVotes + "]";
	}
}
