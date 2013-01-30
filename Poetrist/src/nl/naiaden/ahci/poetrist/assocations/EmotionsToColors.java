/**
 * 
 */
package nl.naiaden.ahci.poetrist.assocations;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import nl.naiaden.ahci.poetrist.PoetristColor;
import nl.naiaden.ahci.poetrist.assocations.Emotions.EmotionType;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;

/**
 * @author louis
 * 
 */
public class EmotionsToColors
{

	public class EmotionColorWeight
	{
		private EmotionType emotion;
		private Color color;
		private double weight;

		public EmotionColorWeight(EmotionType emotion, Color color, double weight)
		{
			this.emotion = emotion;
			this.color = color;
			this.weight = weight;
		}

		public EmotionType getEmotionType()
		{
			return emotion;
		}

		public Color getColor()
		{
			return color;
		}

		public double getWeight()
		{
			return weight;
		}

	}
	
	private List<EmotionColorWeight> emcWeights = null;
	
	private void initialiseWeights()
	{
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.white, 2.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.black, 30.7));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.red, 32.4));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.green, 5));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.yellow, 5));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.blue, 2.4));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, PoetristColor.brown, 6.6));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.pink, 0.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, PoetristColor.purple, 2.3));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.orange, 2.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.anger, Color.gray, 9.9));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.white, 4.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.black, 31.8));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.red, 25));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.green, 3.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.yellow, 6.9));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.blue, 3));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, PoetristColor.brown, 6.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.pink, 1.3));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, PoetristColor.purple, 2.3));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.orange, 3.3));
		emcWeights.add(new EmotionColorWeight(EmotionType.fear, Color.gray, 11.8));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.white, 		16.2));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.black, 		7.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.red, 			11.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.green, 		16.2));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.yellow, 		10.7));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.blue, 		9.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, PoetristColor.brown,5.7 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.pink, 		5.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation,PoetristColor.purple,3.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.orange, 		4.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.anticipation, Color.gray, 		8.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.white, 				22  ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.black, 				6.3 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.red, 				8.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.green, 				14.2));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.yellow, 				8.3 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.blue, 				14.4));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, PoetristColor.brown, 		5.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.pink, 				5.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, PoetristColor.purple, 		4.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.orange, 				3.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.trust, Color.gray, 				5.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.white, 			11  ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.black, 			13.4));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.red, 				21  ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.green, 			8.3 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.yellow, 			13.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.blue, 			5.2 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, PoetristColor.brown, 	3.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.pink, 			5.2 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, PoetristColor.purple, 	4.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.orange, 			5.6 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.surprise, Color.gray, 			8.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.white, 			3   ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.black, 			36  ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.red, 				18.6));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.green,				3.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.yellow, 			5.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.blue, 				5.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, PoetristColor.brown, 	7.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.pink, 				0.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, PoetristColor.purple,	1.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.orange, 			2.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.sadness, Color.gray, 				16.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.white, 				21.8));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.black, 				2.2 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.red, 					7.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.green, 				14.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.yellow, 				13.4));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.blue, 					11.3));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, PoetristColor.brown, 		3.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.pink, 					11.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, PoetristColor.purple, 		6.3 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.orange, 				5.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.joy, Color.gray, 					2.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.white, 			2   ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.black, 			33.7));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.red, 				24.9));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.green, 			4.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.yellow,			5.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.blue, 				1.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, PoetristColor.brown,		9.7 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.pink, 				1.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, PoetristColor.purple, 	1.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.orange, 			3.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.disgust, Color.gray, 				10.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.white, 			2.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.black, 			28.3));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.red, 				21.6));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.green, 			4.7 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.yellow, 			6.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.blue, 			4.1 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, PoetristColor.brown, 	9.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.pink, 			1.2 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, PoetristColor.purple, 	2.5 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.orange, 			3.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.positive, Color.gray, 			14.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.white, 			20.1));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.black, 			3.9 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.red, 				8   ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.green, 			15.5));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.yellow,			10.8));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.blue, 			12  ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, PoetristColor.brown, 	4.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.pink, 			7.8 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, PoetristColor.purple, 	5.7 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.orange, 			5.4 ));
		emcWeights.add(new EmotionColorWeight(EmotionType.negative, Color.gray, 			5.7 ));
	}

	private double getEMCWeight(EmotionType emotion, Color color)
	{
		for(EmotionColorWeight emc : emcWeights)
		{
			if(emc.getEmotionType().equals(emotion) && emc.getColor().equals(color))
			{
				return emc.getWeight();
			}
		}
		
		return 0;
	}
	
	private double getEmotionWeight(EmotionType emotion)
	{
		for(WeightedEmotion we : weightedEmotions)
		{
			if(we.getEmotionType().equals(emotion))
			{
				// return we.getWeight();
				return 1.0;
				// TODO
			}
		}
		
		return 0;
	}
	
	private List<WeightedColor> weightedColors = null;
	private List<WeightedEmotion> weightedEmotions = null;

	public List<WeightedColor> getWeightedColors()
	{
		return weightedColors;
	}
	
	public EmotionsToColors(List<WeightedEmotion> weightedEmotions)
	{
		
		emcWeights = new ArrayList<EmotionsToColors.EmotionColorWeight>();
		weightedColors = new ArrayList<WeightedColor>();

		for (Color c : PoetristColor.getPoetristColors())
		{
			weightedColors.add(new WeightedColor(c, 0.0));
		}

		this.weightedEmotions = weightedEmotions;

		initialiseWeights();
		
		/*
		 * For each weighted emotion, we want to build a colour profile
		 */
		for (WeightedEmotion weE : weightedEmotions) // the weighted emotions
		{
			for (EmotionColorWeight ecw : emcWeights) // the colour weights
			{
				if (ecw.getEmotionType().equals(weE.getEmotionType()))
				{
					for (WeightedColor weC : weightedColors)
					{
						if (ecw.getColor().equals(weC.getColor()))
						{
							double colourWeight = ecw.getWeight() * weE.getAverageWeight();
							if (!Double.isNaN(colourWeight))
							{
								weC.add(colourWeight);
							}
						}
					}
				}
			}
		}

		for (WeightedColor weC : weightedColors)
		{
			System.out.println(">>>> " + weC);
		}
	}
}
