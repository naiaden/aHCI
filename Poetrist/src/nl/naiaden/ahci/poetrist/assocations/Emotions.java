package nl.naiaden.ahci.poetrist.assocations;

import java.util.ArrayList;
import java.util.List;

import nl.naiaden.ahci.poetrist.lexicon.Emotion;
import nl.naiaden.ahci.poetrist.lexicon.Entry;
import nl.naiaden.ahci.poetrist.lexicon.WordEmotion;

/**
 * contains the magnitude of the emotion in a poem, the order of the magnitude
 * is the same as the order in the enumeration and data set.
 * 
 * @author Stef Janssen
 * 
 */
public class Emotions
{
	// private double [] magnitudes ; //the magnitudes for the emotionTypes
	private List<WeightedEmotion> weightedEmotions = null;
	private double meanMagnitude; // the mean magnitude if we want to normalize
	private int numberAddedWords; // how many emotions have been added to this
									// poem

	public enum EmotionType
	{
		anger, anticipation, disgust, fear, joy, negative, positive, sadness, surprise, trust
	}

	public List<WeightedEmotion> getWeightedEmotions()
	{
		return weightedEmotions;
	}

	/**
	 * constructor of class
	 */
	public Emotions()
	{
		weightedEmotions = new ArrayList<WeightedEmotion>();
		for (EmotionType et : EmotionType.values())
		{
			weightedEmotions.add(new WeightedEmotion(et, 0));
		}

		// magnitudes = new double [nEmotionTypes];
		meanMagnitude = 0;
		numberAddedWords = 0;
	}

	// TODO: add een functie waarmee je een hele lijst entries kan geven

	private WeightedEmotion getWeightedEmotion(EmotionType emotion)
	{
		for (WeightedEmotion we : weightedEmotions)
		{
			if (we.getEmotionType().equals(emotion)) { return we; }
		}

		return null;
	}

	// public void add(Emotion emotion)
	// {
	// for (WeightedEmotion we : weightedEmotions)
	// {
	// if (emotion.getEmotion().equals(we.getEmotionType().toString()))
	// {
	// // System.out.println(">" + we);
	// }
	// }
	// }

	public void add(List<WordEmotion> wordEmotions)
	{
		for (WordEmotion woE : wordEmotions)
		{
			for (WeightedEmotion weE : weightedEmotions)
			{
				if (woE.getEmotion().toString().equals(weE.getEmotionType().toString()))
				{
					weE.add(woE.getScore() ? 1.0 : 0.0);
					// System.out.println(">(" + weightedEmotions.size() + ")>"
					// + weE);
				}
			}
		}

		// for (WeightedEmotion weE : weightedEmotions)
		// {
		// System.out.println("OOO " + weE);
		// }
	}

	// /**
	// * adds a new word to the list of magnitudes
	// *
	// * @param newMagnitudes
	// * : a list of booleans where each index corresponds to the
	// * emotion in EmotionType
	// */
	// public void addMagnitudes(List<WordEmotion> wordEmotions)
	// {
	//
	// double total = 0;
	//
	// for (WordEmotion we : wordEmotions)
	// {
	// if (we.getScore())
	// {
	// ++total;
	// for (EmotionType emotion : EmotionType.values())
	// {
	// WeightedEmotion weightedEmotion = getWeightedEmotion(emotion);
	// if (weightedEmotion != null)
	// {
	// weightedEmotion.setWeight(weightedEmotion.getAverageWeight() + 1);
	// }
	// }
	// }
	// }
	//
	// for (WeightedEmotion we : weightedEmotions)
	// {
	// System.out.println(we);
	// }
	//
	// // for(WordEmotion w:wordEmotions) {
	// // if(w.getScore()){
	// // total++;
	// // for(int i=0; i < nEmotionTypes;i++)
	// // if(w.getEmotion().toString().equals(
	// // EmotionType.values()[i].toString()))
	// // {
	// // // magnitudes[i] = magnitudes[i] + 1;
	// // weightedEmotions.get(index)
	// // }
	// // }
	// // }
	// meanMagnitude = (meanMagnitude * numberAddedWords + total) /
	// (numberAddedWords + 1);
	// numberAddedWords++;
	//
	// }

	/**
	 * returns the mean of the magnitudes of the emotions
	 * 
	 * @return
	 */
	public double getMeanMagnitude()
	{
		return meanMagnitude;
	}

	/**
	 * returns how many times a word has affected the emotions of the poem
	 * 
	 * @return
	 */
	public int getAddedWords()
	{
		return numberAddedWords;
	}

	// /**
	// * displays the magnitudes of all the emotions
	// */
	// public void showMagnitudes()
	// {
	// System.out.println("Mean magnitude = " + new
	// Double(meanMagnitude).toString());
	//
	// for (EmotionType et : EmotionType.values())
	// {
	// if (et != null)
	// {
	// WeightedEmotion weightedEmotion = getWeightedEmotion(et);
	// if (weightedEmotion != null)
	// System.out.println("Magnitude of " + et.toString() + ": " +
	// weightedEmotion.getWeight());
	// }
	// }
	//
	// }
	//
	// // public double[] getMagnitudes() {
	// // return magnitudes;
	// // }
	//
	// /**
	// * returns the magnitude of the type of emotion which is inputted
	// *
	// * @param emotion
	// * @return
	// */
	// public double getMagnitude(EmotionType emotion)
	// {
	// for (WeightedEmotion we : weightedEmotions)
	// {
	// if (we.getEmotionType().equals(emotion)) { return we.getWeight(); }
	// }
	//
	// // for(int i=0; i < EmotionType.values().length; i++)
	// // if(EmotionType.values()[i].equals(emotion))
	// // return magnitudes[i];
	// return (Double) null;
	// }

}
