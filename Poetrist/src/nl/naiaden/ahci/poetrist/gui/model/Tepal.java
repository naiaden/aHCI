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
public class Tepal extends Observable {

	/**
	 * The colour of the tepal.
	 */
	private Color tepalColour;

	/**
	 * Creates a coloured tepal.
	 */
	public Tepal(Color tepalColour) {
		this.tepalColour = tepalColour;
	}

	/**
	 * 
	 * @return The tepal colour.
	 */
	public Color getColour() {
		return tepalColour;
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
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		Tepal rhs = (Tepal) obj;
		// temporary fix, as colour will be word-colour later
		return false;
//		return tepalColour.equals(rhs.getColour());
	}
}
