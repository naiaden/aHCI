/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;
import java.io.Serializable;

/**
 * @author louis
 *
 */
public class OldWord implements Serializable
{
	public String word;
	public Color color;

	public OldWord(String word, Color color)
	{
		this.word = word;
		this.color = color;
	}

	@Override
	public String toString()
	{
		return word;
	}
}
