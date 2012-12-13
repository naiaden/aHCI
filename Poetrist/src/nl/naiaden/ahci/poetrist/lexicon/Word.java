/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;

/**
 * @author louis
 *
 */
public class Word		//TODO: why do we need a word color association, we go from word to emotion to color
{
	public String word;
	public Color color;

	public Word(String word, Color color)
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
