/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

/**
 * @author Ding
 * @author louis
 * 
 */
public class Word implements LexiconEntry
{
	private String word;

	public Word(String word)
	{
		this.word = word;
	}

	public String getWord()
	{
		return word;
	}

	public String toString()
	{
		return word;
	}
}
