package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import nl.naiaden.ahci.poetrist.PoetristColor;

public class WordColorFeatureVector implements Serializable
{
	final Word word;
	List<Double> featureVector = new ArrayList<Double>(PoetristColor.getNumberOfColors());

	public WordColorFeatureVector(WordColor wordColor)
	{
		this.word = wordColor.getWord();
		for (int i = 0; i < PoetristColor.getNumberOfColors(); ++i)
		{
			featureVector.add(0.0);
		}

		featureVector.set(PoetristColor.getColorPosition(wordColor.getColor().getColor()), wordColor.getConfidence());
	}

	public void set(Color color, double confidence)
	{
		featureVector.set(PoetristColor.getColorPosition(color), Double.valueOf(confidence));
	}

	public String toString()
	{
		return word.toString() + " - " + featureVector.toString();
	}

	public double cosineSimilarity(WordColorFeatureVector rhs)
	{
		double similarity = 0;

		double numerator = 0;
		double a = 0;
		double b = 0;

		// A . B / ||A|| ||B||
		for (int i = 0; i < PoetristColor.getNumberOfColors(); ++i)
		{
			double ai = featureVector.get(i);
			double bi = rhs.featureVector.get(i);
			numerator += (ai * bi);
			a += ai * ai;
			b += bi * bi;
		}

		// System.out.println(numerator + "/ (" + Math.sqrt(a) + " * " +
		// Math.sqrt(b) + ")");
		similarity = numerator / (Math.sqrt(a) * Math.sqrt(b));

		return similarity;
	}
}