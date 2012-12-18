/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

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
}
