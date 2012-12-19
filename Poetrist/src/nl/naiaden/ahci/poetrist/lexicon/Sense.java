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
public class Sense implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2175656299958194271L;
	private String sense;

	public Sense(String sense)
	{
		this.sense = sense;
	}

	public String getSense()
	{
		return sense;
	}

	public String toString()
	{
		return sense;
	}

	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		Sense rhs = (Sense) obj;
		return sense.equals(rhs.getSense());
	}
}
