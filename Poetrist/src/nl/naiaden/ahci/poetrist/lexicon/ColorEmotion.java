/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.io.Serializable;

/**
 * @author louis
 *
 */
public class ColorEmotion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9176831993163187761L;
	private final ColorName color;
	private final Emotion emotion;

	public ColorEmotion(ColorName color, Emotion emotion)
	{
		this.color = color;
		this.emotion = emotion;
	}

	public ColorName getColor()
	{
		return color;
	}

	public Emotion getEmotion()
	{
		return emotion;
	}

	public String toString()
	{
		return color.toString() + " <--> " + emotion.toString();
	}
}
