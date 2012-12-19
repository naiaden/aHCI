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
public class WordSense implements LexiconEntry, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -705698695263899059L;
	private final Word word;
	private final Sense sense;

	public WordSense(Word word, Sense sense)
	{
		this.word = word;
		this.sense = sense;
	}

	public Word getWord()
	{
		return word;
	}

	public Sense getSense()
	{
		return sense;
	}

	public String toString()
	{
		return word.toString() + "--" + sense.toString();
	}
}
