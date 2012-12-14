package nl.naiaden.ahci.poetrist.lexicon;

import java.util.ArrayList;

/**
 * contains the magnitude of the emotion in a poem, the order of the magnitude is 
 * the same as the order in the enumeration and data set.
 * @author Stef Janssen
 *
 */
public class Emotions
{
	private double [] magnitudes ;			//the magnitudes for the emotionTypes
	private double meanMagnitude;
	private int numberAddedEmotions;		//how many emotions have been added to this poem
	public final int nEmotionTypes = 10;
	public enum EmotionTypes {
		ANGER, 
		ANTICIPATION, 
		DISGUST, 
		FEAR, 
		JOY, 
		NEGATIVE,
		POSITIVE,
		SADNESS,
		SURPRISE,
		TRUST
	}
	
	/**
	 * constructor of class
	 */
	public Emotions() {
		magnitudes = new double [nEmotionTypes];
		meanMagnitude = 0;
		numberAddedEmotions =0;
	}
	
	/**
	 * adds a the list of magnitudes 
	 * @param newMagnitudes: a list of booleans where each index corresponds to the emotion
	 * in EmotionTypes
	 */
	public void addMagnitudes(boolean [] newMagnitudes) {
		double total=0;
		for(int i=0; i < nEmotionTypes;i++) {
			if(newMagnitudes[i]){
				total++;
				magnitudes[i] = (numberAddedEmotions * magnitudes[i] + 1)/(numberAddedEmotions+1);
			}
		}
		meanMagnitude = (meanMagnitude*numberAddedEmotions + total)/(numberAddedEmotions+1);
		numberAddedEmotions++;
	}
	
}
