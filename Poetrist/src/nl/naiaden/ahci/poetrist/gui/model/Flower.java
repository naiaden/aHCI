/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The flower represents a word-colour association, where its tepals are related
 * words. A flower can have a certain number of tepals, thus limiting the number
 * of words related to the flower's core.
 * 
 * <br>
 * The flower itself represents an interaction pattern. Its tepals can be pulled
 * of, new flowers can be planted, and so on.
 * 
 * @author louis
 * 
 */
public class Flower extends Observable {

	/**
	 * The maximum number of tepals.
	 */
	private int numberOfTepalPositions;

	/**
	 * The colour on the inside of the flower.
	 */
	private Color coreColour;

	/**
	 * The tepals.
	 */
	private List<Tepal> tepals = null;

	/**
	 * Creates a (default) flower with a maximum of 8 tepals.
	 * 
	 * @see Flower#Flower(int)
	 */
	public Flower() {
		this(8);
	}

	/**
	 * Creates a new flower.
	 * 
	 * @param numberOfTepals
	 *            The number of tepals
	 */
	public Flower(int numberOfTepals) {
		this.numberOfTepalPositions = numberOfTepals;

		tepals = new ArrayList<Tepal>();
	}

	/**
	 * Adds a tepal to the flower if there is a vacant tepal position and the
	 * petal was not already present.
	 * 
	 * @param tepal
	 *            The new tepal.
	 * @return <code>true</code> if the tepal is added, <code>false</code>
	 *         otherwise.
	 */
	public boolean addTepal(Tepal tepal) {
		if (tepals.size() < numberOfTepalPositions) {
			if (tepals.contains(tepal)) {
				return false;
			}

			tepals.add(tepal);
			setChanged();
			notifyObservers(this);
			System.out.println("Adding tepal");
			return true;
		}

		return false;
	}

	/**
	 * Removes a tepal from the flower.
	 * 
	 * @param tepal
	 * @return <code>true</code> if the tepal is deleted, <code>false</code>
	 *         otherwise (also if the tepal was not present).
	 */
	public boolean removeTepal(Tepal tepal) {
		boolean removed = tepals.remove(tepal);

		if (removed) {
			setChanged();
			notifyObservers(this);
		}

		return removed;
	}
	
	public Color getColour()
	{
		return coreColour;
	}
	
	public List<Tepal> getTepals()
	{
		return tepals;
	}
	
	/**
	 * Determines whether another object is equal to this Flower. The result is
	 * true if and only if the argument is not null and is a Flower object that
	 * has the same tepals as this object.
	 * 
	 * @param obj
	 *            the object to test for equality with this Flower.
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

		Flower rhs = (Flower) obj;
		return coreColour.equals(rhs.getColour()) && tepals.equals(rhs.getTepals());
	}
}
