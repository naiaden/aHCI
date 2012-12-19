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
public class WordEmotion implements LexiconEntry, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6828962503265719020L;
	private final Word word;
	private final Emotion emotion;

	private int score;

	public WordEmotion(Word word, Emotion emotion)
	{
		this.word = word;
		this.emotion = emotion;
	}

	public WordEmotion(Word word, Emotion emotion, int score)
	{
		this.word = word;
		this.emotion = emotion;

		this.score = score;
	}

	public Word getWord()
	{
		return word;
	}

	public Emotion getEmotion()
	{
		return emotion;
	}

	public int getScore()
	{
		return score;
	}

	public String toString()
	{
		return word.toString() + "--" + emotion.toString() + "(" + score + ")";
	}
}
