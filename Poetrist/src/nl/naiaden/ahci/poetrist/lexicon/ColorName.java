/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;

import nl.naiaden.ahci.poetrist.PoetristColor;

/**
 * @author Ding
 * @author louis
 * 
 */
public class ColorName implements LexiconEntry
{
	private Color color;
	
	public ColorName(String colorName)
	{
		color = PoetristColor.getColor(colorName);
	}
	
	public Color getColor()
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

	public String toString()
	{
		return PoetristColor.toString(color);
	}
}
