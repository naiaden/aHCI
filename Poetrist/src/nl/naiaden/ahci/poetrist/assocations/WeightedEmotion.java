/**
 * 
 */
package nl.naiaden.ahci.poetrist.assocations;

import java.awt.Color;

import nl.naiaden.ahci.poetrist.assocations.Emotions.EmotionType;

/**
 * @author louis
 *
 */
public class WeightedEmotion
{
	private EmotionType emotion;
	private double weight;

	public WeightedEmotion(EmotionType emotion, double weight)
	{
		this.emotion = emotion;
		this.weight = weight;
	}

	public EmotionType getEmotionType()
	{
		return emotion;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}
}
