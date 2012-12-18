/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

/**
 * @author Ding
 * @author louis
 * 
 */
public class WordColor implements LexiconEntry
{
	private final Word word;
	private final ColorName color;

	public WordColor(Word word, ColorName color)
	{
		this.word = word;
		this.color = color;
	}

	public Word getWord()
	{
		return word;
	}

	public ColorName getColor()
	{
		return color;
	}
}
