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
	private double weight = 0;
	private double normalisation = 0;

	public WeightedEmotion(EmotionType emotion, double weight)
	{
		this.emotion = emotion;
		this.weight = weight;
	}


	public void add(double weight)
	{
		this.weight += weight;
		++normalisation;
	}

	public EmotionType getEmotionType()
	{
		return emotion;
	}

	public double getAverageWeight()
	{
		return weight / normalisation;
	}

	public double getRawWeight()
	{
		return weight;
	}

	public String toString()
	{
		return "[" + emotion + "]: " + weight;
	}
}
