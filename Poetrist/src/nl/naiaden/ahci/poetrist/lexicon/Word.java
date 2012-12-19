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
public class Word implements LexiconEntry, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7978153224030276938L;
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
