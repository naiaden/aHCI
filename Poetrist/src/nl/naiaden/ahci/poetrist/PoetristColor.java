package nl.naiaden.ahci.poetrist;

import java.awt.Color;
/**
 * Extended version of java.awt.Color
 * Needed since the original had no
 * build-in support for the colors 
 * brown and purple.
 * @author Nellethor
 * @version 0.1
 *
 */
public class PoetristColor extends Color
{

	public PoetristColor(int r, int g, int b)
	{
		super(r, g, b);
	}

	public static final PoetristColor brown = new PoetristColor(150, 75, 0);
	public static final PoetristColor BROWN = brown;
	public static final PoetristColor purple = new PoetristColor(128, 0, 128);
	public static final PoetristColor PURPLE = purple;
	
	public static String toString(Color color)
	{
		if (color.equals(PoetristColor.brown))
			return "brown";
		if (color.equals(PoetristColor.magenta))
			return "pink";
		if (color.equals(PoetristColor.purple))
			return "purple";
		if (color.equals(PoetristColor.black))
			return "black";
		if (color.equals(PoetristColor.red))
			return "red";
		if (color.equals(PoetristColor.green))
			return "green";
		if (color.equals(PoetristColor.blue))
			return "blue";
		if (color.equals(PoetristColor.yellow))
			return "yellow";
		if (color.equals(PoetristColor.gray))
			return "grey";
		if (color.equals(PoetristColor.white))
			return "white";
		if (color.equals(PoetristColor.orange))
			return "orange";

		return null;
	}

	public static Color getColor(String colorName)
	{
		String normalisedColorName = colorName.toLowerCase();

		if (normalisedColorName.equals("brown"))
			return PoetristColor.brown;
		if (normalisedColorName.equals("pink"))
			return PoetristColor.magenta;
		if (normalisedColorName.equals("purple"))
			return PoetristColor.purple;
		if (normalisedColorName.equals("black"))
			return PoetristColor.black;
		if (normalisedColorName.equals("red"))
			return PoetristColor.red;
		if (normalisedColorName.equals("green"))
			return PoetristColor.green;
		if (normalisedColorName.equals("blue"))
			return PoetristColor.blue;
		if (normalisedColorName.equals("yellow"))
			return PoetristColor.yellow;
		if (normalisedColorName.equals("grey"))
			return PoetristColor.gray;
		if (normalisedColorName.equals("gray"))
			return PoetristColor.gray;
		if (normalisedColorName.equals("white"))
			return PoetristColor.white;
		if (normalisedColorName.equals("orange"))
			return PoetristColor.orange;

		System.err.println("[PoetristColor#getColor(String)] Something went terrible wrong, as I got " + colorName + " as input");
		return null;
	}
}