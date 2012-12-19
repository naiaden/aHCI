/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.model;

import java.awt.Color;
import java.util.Observable;

import nl.naiaden.ahci.poetrist.lexicon.WordColor;

/**
 * The tepal is either a petal or sepal of the flower. Since we do not
 * distinguish between those two, we use the biological name tepal for them. A
 * tepal of our metaphorical flower is a word-colour association, particularly
 * with a certain relation to the word of the flower, as denoted by the stigma.
 * 
 * @author louis
 * 
 */
public class Tepal extends Observable implements FlowerPart
{

	/**
	 * The colour of the tepal.
	 */
	private WordColor wordColor;

	/**
	 * Creates a coloured tepal.
	 */
	public Tepal(WordColor wordColor)
	{
		this.wordColor = wordColor;
	}

	/**
	 * Determines whether another object is equal to this Tepal. The result is
	 * true if and only if the argument is not null and is a Tepal object that
	 * has the same colour value as this object.
	 * 
	 * @param obj
	 *            the object to test for equality with this Tepal.
	 * @return <code>true</code> if the objects are the same; <code>false</code>
	 *         otherwise.
	 */
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		Tepal rhs = (Tepal) obj;
		return wordColor.equals(rhs.getWordColor());
	}

	/**
	 * Returns the colour of the tepal.
	 * 
	 * @return The tepal colour.
	 */
	public WordColor getWordColor()
	{
		return wordColor;
	}
}
