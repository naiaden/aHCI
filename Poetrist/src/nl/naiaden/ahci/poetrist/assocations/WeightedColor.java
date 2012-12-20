/**
 * 
 */
package nl.naiaden.ahci.poetrist.assocations;

import java.awt.Color;

/**
 * @author louis
 *
 */
public class WeightedColor
{
	private Color color;
	private double weight;

	public WeightedColor(Color color, double weight)
	{
		this.color = color;
		this.weight = weight;
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
