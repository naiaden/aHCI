/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import nl.naiaden.ahci.poetrist.gui.model.Flower;

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

	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		Word rhs = (Word) obj;
		return word.equals(rhs.getWord());
	}
}
