package nl.naiaden.ahci.poetrist.stringtoemotion;

import java.util.ArrayList;
import java.util.List;

import nl.naiaden.ahci.poetrist.lexicon.Entry;
import nl.naiaden.ahci.poetrist.lexicon.WordEmotion;

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
	private int numberAddedWords;		//how many emotions have been added to this poem
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
		numberAddedWords =0;
	}
	
	//TODO: add een functie waarmee je een hele lijst entries kan geven
	
	/**
	 * adds a new word to the list of magnitudes 
	 * @param newMagnitudes: a list of booleans where each index corresponds to the emotion
	 * in EmotionTypes
	 */
	public void addMagnitudes(List<WordEmotion> wordEmotions) {
		double total=0;
		for(WordEmotion w:wordEmotions) {
			if(w.getScore()){
				total++;
				for(int i=0; i < nEmotionTypes;i++)
				{
					System.out.println("an emotion: " + w.getEmotion().toString());
					if(w.getEmotion().toString() == EmotionTypes.values()[i].toString())
						magnitudes[i] = magnitudes[i] + 1;
				}
			}
		}
		meanMagnitude = (meanMagnitude*numberAddedWords + total)/(numberAddedWords+1);
		numberAddedWords++;
		
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
	public int getAddedWords() {
		return numberAddedWords;
	}
	
	/**
	 * displays the magnitudes of all the emotions
	 */
	public void showMagnitudes()
	{
		for(int i=0; i < nEmotionTypes;i++)
			System.out.println("Magnitude of " + EmotionTypes.values()[i].toString() + ": " + new Double(magnitudes[i]).toString());
	}
	
}
