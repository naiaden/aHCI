/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

/**
 * @author Ding
 * @author louis
 * 
 */
public class WordEmotion implements LexiconEntry
{
	private final Word word;
	private final Emotion emotion;

	public WordEmotion(Word word, Emotion emotion)
	{
		this.word = word;
		this.emotion = emotion;
	}

	public Word getWord()
	{
		return word;
	}

	public Emotion getEmotion()
	{
		return emotion;
	}
}
