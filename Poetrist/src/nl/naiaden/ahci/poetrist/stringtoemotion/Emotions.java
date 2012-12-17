package nl.naiaden.ahci.poetrist.stringtoemotion;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.lexicon.Entry;

/**
 * contains the magnitude of the emotion in a poem, the order of the magnitude is 
 * the same as the order in the enumeration and data set.
 * @author Stef Janssen
 *
 */
public class Emotions
{
	private double [] magnitudes ;			//the magnitudes for the emotionTypes
	private double meanMagnitude;			//the mean magnitude if we want to normalize
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
	
	//TODO: add een functie waarmee je een hele lijst entries kan geven
	
	/**
	 * adds a new word to the list of magnitudes 
	 * @param newMagnitudes: a list of booleans where each index corresponds to the emotion
	 * in EmotionTypes
	 */
	public void addMagnitudes(Entry entry) {
		ArrayList<Boolean> newMagnitudes = entry.getAssociations();	//TODO: check of deze functie goed de MEAN berekent...
		double total=0;
		for(int i=0; i < nEmotionTypes;i++) {
			if(newMagnitudes.get(i)){
				total++;
				magnitudes[i] = (numberAddedEmotions * magnitudes[i] + 1)/(numberAddedEmotions+1);
			}
		}
		meanMagnitude = (meanMagnitude*numberAddedEmotions + total)/(numberAddedEmotions+1);
		numberAddedEmotions++;
	}
	
	/**
	 * returns the mean  of the magnitudes of the emotions
	 * @return
	 */
	public double getMeanMagnitude() {
		return meanMagnitude;
	}
	
	/**
	 * returns how many times a word has affected the emotions of the poem
	 * @return
	 */
	public int getAddedEmotions() {
		return numberAddedEmotions;
	}
	
}
