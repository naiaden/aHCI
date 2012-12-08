/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.model;

import java.awt.Color;
import java.util.Observable;

/**
 * @author louis
 *
 */
public class Stigma extends Observable
{
	private Color stigmaColour;
	
	public Stigma(Color stigmaColour)
	{
		this.stigmaColour = stigmaColour;
	}
	
	public Color getColour()
	{
		return stigmaColour;
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
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		Stigma rhs = (Stigma) obj;
		return stigmaColour.equals(rhs.getColour());
	}
}
