/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import nl.naiaden.ahci.poetrist.gui.model.Flower;

/**
 * @author Ding
 * @author louis
 * 
 */
public class Emotion implements LexiconEntry
{
	private String emotion;

	public Emotion(String emotion)
	{
		this.emotion = emotion;
	}

	public String getEmotion()
	{
		return emotion;
	}

	public String toString()
	{
		return emotion;
	}

	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;

		Emotion rhs = (Emotion) obj;
		return emotion.equals(rhs.getEmotion());
	}
}
