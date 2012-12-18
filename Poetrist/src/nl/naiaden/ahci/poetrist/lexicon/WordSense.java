/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

/**
 * @author Ding
 * @author louis
 * 
 */
public class WordSense implements LexiconEntry
{
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
}
