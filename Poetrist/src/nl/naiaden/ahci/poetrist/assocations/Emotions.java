package nl.naiaden.ahci.poetrist.assocations;

import java.util.ArrayList;
import java.util.List;

import nl.naiaden.ahci.poetrist.lexicon.Emotion;
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
		anger, 
		anticipation, 
		disgust, 
		fear, 
		joy, 
		negative,
		positive,
		sadness,
		surprise,
		trust
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
					if(w.getEmotion().toString().equals( EmotionTypes.values()[i].toString()))
						magnitudes[i] = magnitudes[i] + 1;
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
		System.out.println("Mean magnitude = " + new Double(meanMagnitude).toString());
		for(int i=0; i < nEmotionTypes;i++)
			System.out.println("Magnitude of " + EmotionTypes.values()[i].toString() + ": " + new Double(magnitudes[i]).toString());
	}
	
	public double[] getMagnitudes() {
		return magnitudes;
	}
	
	/**
	 * returns the magnitude of the type of emotion which is inputted
	 * @param emotion
	 * @return
	 */
	public double getMagnitude(EmotionTypes emotion) {
		for(int i=0; i < EmotionTypes.values().length; i++)
			if(EmotionTypes.values()[i].equals(emotion))
				return magnitudes[i];
		return (Double) null;
	}
	
}
