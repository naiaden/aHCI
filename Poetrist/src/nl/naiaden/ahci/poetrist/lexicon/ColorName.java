/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import nl.naiaden.ahci.poetrist.PoetristColor;

/**
 * @author Ding
 * @author louis
 * 
 */
public class ColorName implements LexiconEntry
{
	private PoetristColor color;
	
	public ColorName(String color)
	{
		//
	}
	
	public PoetristColor getColor()
	{
		return color;
	}

	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		ColorName rhs = (ColorName) obj;
		return color.equals(rhs.getColor());
	}
}
