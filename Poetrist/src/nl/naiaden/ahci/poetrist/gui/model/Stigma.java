/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.model;

import java.awt.Color;
import java.util.Observable;

/**
 * The stigma is the centre of the flower. The stigma of our metaphorical flower
 * is a word-colour assocation.
 * 
 * @author louis
 * 
 */
public class Stigma extends Observable implements FlowerPart
{
	/**
	 * The colour of the stigma.
	 */
	private Color stigmaColour;

	/**
	 * Creates a stigma with the given colour.
	 * 
	 * @param stigmaColour
	 *            The colour of the stigma.
	 */
	public Stigma(Color stigmaColour)
	{
		this.stigmaColour = stigmaColour;
	}

	/**
	 * Determines whether another object is equal to this Stigma. The result is
	 * true if and only if the argument is not null and is a Stigma object that
	 * has the same colour value as this object.
	 * 
	 * @param obj
	 *            the object to test for equality with this Stigma.
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

		Stigma rhs = (Stigma) obj;
		// temporary fix, as colour will be word-colour later
		return false;
		// return stigmaColour.equals(rhs.getColour());
	}

	/**
	 * Returns the colour of the stigma.
	 * 
	 * @return the colour of the stigma.
	 */
	public Color getColour()
	{
		return stigmaColour;
	}
}
