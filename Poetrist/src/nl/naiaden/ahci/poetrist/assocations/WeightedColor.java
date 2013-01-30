/**
 * 
 */
package nl.naiaden.ahci.poetrist.assocations;

import java.awt.Color;

import nl.naiaden.ahci.poetrist.PoetristColor;

/**
 * @author louis
 *
 */
public class WeightedColor
{
	private Color color;
	private double weight = 0;
	private double normalisation = 0;

	public WeightedColor(Color color, double aWeight)
	{
		this.color = color;
		this.weight = aWeight;
	}

	public void add(double aWeight)
	{
		// System.out.println("Adding " + aWeight + " to " + this.weight + " = "
		// + (aWeight + this.weight));
		this.weight += aWeight;

		++normalisation;
	}

	public Color getColor()
	{
		return color;
	}

	public double getWeight()
	{
		return weight;
	}

	public String toString()
	{
		return PoetristColor.toString(color) + ": " + weight;
	}
}
