/**
 * 
 */
package nl.naiaden.ahci.poetrist.assocations;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ListUI;

import nl.naiaden.ahci.poetrist.PoetristColor;
import nl.naiaden.ahci.poetrist.assocations.Emotions.EmotionTypes;

/**
 * @author louis
 * 
 */
public class EmotionsToColors
{

	private static double[][] feelingxcolor =
	{
	{ 2.1, 30.7, 32.4, 5, 5, 2.4, 6.6, 0.5, 2.3, 2.5, 9.9 },
	{ 4.5, 31.8, 25, 3.5, 6.9, 3, 6.1, 1.3, 2.3, 3.3, 11.8 },
	{ 16.2, 7.5, 11.5, 16.2, 10.7, 9.5, 5.7, 5.9, 3.1, 4.9, 8.4 },
	{ 22, 6.3, 8.4, 14.2, 8.3, 14.4, 5.9, 5.5, 4.9, 3.8, 5.8 },
	{ 11, 13.4, 21, 8.3, 13.5, 5.2, 3.4, 5.2, 4.1, 5.6, 8.8 },
	{ 3, 36, 18.6, 3.4, 5.4, 5.8, 7.1, 0.5, 1.4, 2.1, 16.1 },
	{ 21.8, 2.2, 7.4, 14.1, 13.4, 11.3, 3.1, 11.1, 6.3, 5.8, 2.8 },
	{ 2, 33.7, 24.9, 4.8, 5.5, 1.9, 9.7, 1.1, 1.8, 3.5, 10.5 },
	{ 2.9, 28.3, 21.6, 4.7, 6.9, 4.1, 9.4, 1.2, 2.5, 3.8, 14.1 },
	{ 20.1, 3.9, 8, 15.5, 10.8, 12, 4.8, 7.8, 5.7, 5.4, 5.7 } };

	private EmotionTypes[] emotionTypes =
	{ EmotionTypes.anger, EmotionTypes.fear, EmotionTypes.anticipation, EmotionTypes.trust, EmotionTypes.surprise, EmotionTypes.sadness, EmotionTypes.joy, EmotionTypes.disgust,
			EmotionTypes.positive, EmotionTypes.negative };

	private Color[] colors =
	{ Color.white, Color.black, Color.red, Color.green, Color.yellow, Color.blue, PoetristColor.brown, PoetristColor.pink, PoetristColor.purple, Color.orange, Color.gray };

	public EmotionsToColors(Emotions emotions)
	{
		List<WeightedColor> weightedColors = new ArrayList<WeightedColor>();

		double[] weights = emotions.getMagnitudes();
		double sumWeights = 0;
		for (double d : weights)
		{
			sumWeights += d;
		}

		for (int j = 0; j < feelingxcolor[0].length; j++)
		{
			double sum = 0;
			for (int z = 0; z < feelingxcolor.length; z++)
			{
				sum += feelingxcolor[z][j] * weights[z];
			}

			weightedColors.add(new WeightedColor(colors[j], (sum / sumWeights)));

		}

	}

	public static void main(String[] args)
	{

	}
}
