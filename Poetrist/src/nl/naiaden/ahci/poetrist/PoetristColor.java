package nl.naiaden.ahci.poetrist;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 7204127456902593384L;

	public PoetristColor(int r, int g, int b)
	{
		super(r, g, b);
	}

	public static List<Color> getPoetristColors()
	{
		List<Color> colors = new ArrayList<Color>();
		colors.add(PoetristColor.orange);
		colors.add(PoetristColor.brown);
		colors.add(PoetristColor.magenta);
		colors.add(PoetristColor.purple);
		colors.add(PoetristColor.black);
		colors.add(PoetristColor.red);
		colors.add(PoetristColor.green);
		colors.add(PoetristColor.blue);
		colors.add(PoetristColor.yellow);
		colors.add(PoetristColor.gray);
		colors.add(PoetristColor.white);


		return colors;
	}

	public static int getNumberOfColors()
	{
		return 11;
	}

	public static int getColorPosition(Color color)
	{
		int position = -1;

		if (color.equals(PoetristColor.orange))
			return 0;
		if (color.equals(PoetristColor.brown))
			return 1;
		if (color.equals(PoetristColor.magenta))
			return 2;
		if (color.equals(PoetristColor.purple))
			return 3;
		if (color.equals(PoetristColor.black))
			return 4;
		if (color.equals(PoetristColor.red))
			return 5;
		if (color.equals(PoetristColor.green))
			return 6;
		if (color.equals(PoetristColor.blue))
			return 7;
		if (color.equals(PoetristColor.yellow))
			return 8;
		if (color.equals(PoetristColor.gray))
			return 9;
		if (color.equals(PoetristColor.white))
			return 10;


		return position;
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
