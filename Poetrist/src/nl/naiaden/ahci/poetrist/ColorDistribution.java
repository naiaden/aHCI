package nl.naiaden.ahci.poetrist;

import java.awt.Color;

/**
 * 
 * @author louis
 * 
 */
public class ColorDistribution
{
	private Color color;
	/**
	 * @return the color
	 */
	public Color getColor()
	{
		return this.color;
	}

	/**
	 * @return the percentage
	 */
	public double getPercentage()
	{
		return this.percentage;
	}


	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double percentage)
	{
		this.percentage = percentage;
	}


	private double percentage;
	
	
	public ColorDistribution(Color color, double percentage)
	{
		this.color = color;
		this.percentage = percentage;
	}
}