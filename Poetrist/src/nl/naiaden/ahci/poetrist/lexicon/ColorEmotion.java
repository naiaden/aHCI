/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

/**
 * @author louis
 *
 */
public class ColorEmotion
{
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
}
